package edu.ucsb.cs56.projects.games.pokemon.systems;

import edu.ucsb.cs56.projects.games.pokemon.Vector2;
import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import edu.ucsb.cs56.projects.games.pokemon.components.MovementComponent;
import edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;
import edu.ucsb.cs56.projects.games.pokemon.framework.Ref;

/**
 * Handles all movement
 *
 * @author William Bennett
 */
public class MovementSystem extends SystemBase {

    /**
     * Handles movement and applies it a delta time forward
     *
     * @param deltaT the delta time
     * @param world the world
     */
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

    /**
     * Handles the message for a movement change
     */
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
