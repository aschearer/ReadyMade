importClass(Packages.readymade.entities.ConcreteEntity);
importPackage(Packages.readymade.components);
importPackage(Packages.strikers.components);

/**
 * Creates an icon which follows the mouse.
 */
mark = new ConcreteEntity(id);

body = new PhysicsComponent(128, 128, 16, 16);
mark.addComponent(body);

renderer = new SpriteComponent("strikers/data/res/Mark.png", body);
mark.addComponent(renderer);

engine = new MouseMoveComponent(body);
mark.addComponent(engine);

mark;