START TRANSACTION;

INSERT INTO StoreType (id, name) VALUES (1, 'Electronics');
INSERT INTO StoreType (id, name) VALUES (2,     'Clothes');

INSERT INTO Store (id, name, location, storeTypeId, parentStoreId) VALUES (1,         'Mall',        'TM',  NULL, NULL);
INSERT INTO Store (id, name, location, storeTypeId, parentStoreId) VALUES (2, 'Media Galaxy', '1st floor',     1,    1);
INSERT INTO Store (id, name, location, storeTypeId, parentStoreId) VALUES (3,         'Zara', '2nd floor',     2,    2);

INSERT INTO Section (id, name, storeId) VALUES (1,   'Laptops', 2);
INSERT INTO Section (id, name, storeId) VALUES (2,  'Monitors', 2);
INSERT INTO Section (id, name, storeId) VALUES (3,  'T-shirts', 3);
INSERT INTO Section (id, name, storeId) VALUES (4,   'Blouses', 3);

INSERT INTO Product (id, name, sectionId) VALUES (1, 'Dell XPS 9360', 1);
INSERT INTO Product (id, name, sectionId) VALUES (2,    'Asus UX530', 1);
INSERT INTO Product (id, name, sectionId) VALUES (3, 'Samsung CF791', 2);
INSERT INTO Product (id, name, sectionId) VALUES (4,   'Dell P4317Q', 2);
INSERT INTO Product (id, name, sectionId) VALUES (5,   'White',       3);
INSERT INTO Product (id, name, sectionId) VALUES (6,   'Red',         3);

INSERT INTO Manager (id, name) VALUES (2, 'John');
INSERT INTO StoreManager(storeId, managerId) VALUES (2, 2);
INSERT INTO StoreManager(storeId, managerId) VALUES (3, 2);

COMMIT;