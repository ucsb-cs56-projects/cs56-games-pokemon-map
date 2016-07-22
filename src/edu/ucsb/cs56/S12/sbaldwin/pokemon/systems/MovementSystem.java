package edu.ucsb.cs56.S12.sbaldwin.pokemon.systems;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.World;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.Entity;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.MovementComponent;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.framework.Ref;
import javafx.geometry.Pos;

/**
 * Created by William Bennett on 7/22/2016.
 */
public class MovementSystem extends SystemBase {

    // Two things: Handles movement changed messages, and applies movement
    public void applyMovement(float deltaT, World world) {
        Entity[] entities = world.getEntities();
        handleMessages();
        for (Entity E : entities) {
            PositionComponent PC = (PositionComponent)E.getComponent(PositionComponent.class);
            MovementComponent MC = (MovementComponent)E.getComponent(MovementComponent.class);
            if (PC == null || MC == null)
                continue;

            PC.offset.add(MC.velocity.mult(deltaT));

            if (PC.offset.x > 1) {
                PC.offset.x -= 1;
                PC.position.x++;
            }
            if (PC.offset.x < -1) {
                PC.offset.x += 1;
                PC.position.x--;
            }
            if (PC.offset.y > 1) {
                PC.offset.y -= 1;
                PC.position.y++;
            }
            if (PC.offset.y < -1) {
                PC.offset.y += 1;
                PC.position.y--;
            }
        }
    }

    @Override
    protected void handleMessages() {
        while (!messenger.isEmpty()) {
            SystemMessage msg = messenger.dequeue();
            Ref<Object> value = new Ref<>();
            if (msg.getMessage("movement-changed", value)) {
                MovementComponent MC = (MovementComponent)msg.subject.getComponent(MovementComponent.class);
                Vector2 vel = (Vector2) value.reference;
                MC.velocity = vel;
            }
            else {
                messenger.enqueue(msg);
            }
        }
    }
}
