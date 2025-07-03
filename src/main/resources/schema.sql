-- Создание таблицы dishes
CREATE TABLE dishes (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    calories DOUBLE PRECISION NOT NULL,
    protein DOUBLE PRECISION NOT NULL,
    fat DOUBLE PRECISION NOT NULL,
    carbs DOUBLE PRECISION NOT NULL,
    recipe TEXT
);

-- Добавление тестового блюда
INSERT INTO dishes (name, calories, protein, fat, carbs, recipe)
VALUES ('Овсянка с молоком', 300, 10, 8, 40, 'Залей 50 г овсянки 200 мл молока, вари 5 минут.');