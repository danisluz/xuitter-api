-- Renomeia a coluna somente se ela existir
ALTER TABLE xuit CHANGE COLUMN autor_id author_id BIGINT;

-- Verifica se a constraint 'fk_xuit_user' existe e a remove
SET @fk_name = (SELECT CONSTRAINT_NAME
                FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
                WHERE TABLE_NAME = 'xuit' AND CONSTRAINT_NAME = 'fk_xuit_user');

SET @query = IF(@fk_name IS NOT NULL, CONCAT('ALTER TABLE xuit DROP FOREIGN KEY ', @fk_name), 'SELECT "No FK to drop"');
PREPARE stmt FROM @query;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

-- Adiciona a nova chave estrangeira
ALTER TABLE xuit ADD CONSTRAINT fk_xuit_user FOREIGN KEY (author_id) REFERENCES user (id);