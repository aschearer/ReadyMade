importClass(Packages.readymade.entities.ConcreteEntity);
importPackage(Packages.readymade.components);
importPackage(Packages.strikers.components);

/**
 * Create an entity representing a goal.
 */
ball = new ConcreteEntity(id);

body = new PhysicsComponent(48, 0, 256, 48);
ball.addComponent(body);

renderer = new SpriteComponent("strikers/data/res/Goal.png", body);
ball.addComponent(renderer);

ball;