importClass(Packages.readymade.entities.ConcreteEntity);
importPackage(Packages.readymade.components);
importPackage(Packages.strikers.components);

/**
 * Create an entity representing a soccer player.
 */
player = new ConcreteEntity(id);

body = new PhysicsComponent(48, 48, 64, 64);
player.addComponent(body);

renderer = new RenderComponent("strikers/data/res/Player.png", body);
player.addComponent(renderer);

clicker = new MouseClickComponent(factory, player, body);
player.addComponent(clicker);

player;