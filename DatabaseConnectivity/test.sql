INSERT INTO contacts(name,phone,email)
SELECT * FROM (VALUES
    ('Rhonin', 777777, 'rhonin@warcraft@email.com'),
    ('Sargeras', 666666, 'sargeras@warcraft@email.com'),
    ('Kiljaeden', 666666, 'kiljaeden@warcraft@email.com'),
    ('Archimonde', 666666, 'archimonde@warcraft@email.com')
    )
WHERE NOT EXISTS (SELECT name FROM contacts WHERE name IN
    ('Rhonin', 'Sargeras', 'Kiljaeden', 'Archimonde'));
