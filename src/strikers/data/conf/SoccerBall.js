importClass(Packages.readymade.entities.ConcreteEntity);
importPackage(Packages.readymade.components);
importPackage(Packages.strikers.components);

/**
 * Create an entity representing a soccer ball.
 */
ball = new ConcreteEntity(id);

body = new PhysicsComponent(320, 240, 64, 64);
ball.addComponent(body);

renderer = new RenderComponent("strikers/data/res/SoccerBall.png", body);
ball.addComponent(renderer);

ball;