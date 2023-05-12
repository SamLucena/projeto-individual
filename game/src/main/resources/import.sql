INSERT INTO tb_platforms (name, created_At) VALUES ('Playstation 5', NOW());
INSERT INTO tb_platforms (name, created_At) VALUES ('Playstation 4', NOW());
INSERT INTO tb_platforms (name, created_At) VALUES ('Xbox Series X', NOW());
INSERT INTO tb_platforms (name, created_At) VALUES ('PC', NOW());

INSERT INTO tb_users (name, email, password, created_At) VALUES ('Samuel Lucena', 'sam@gmail.com', '$2a$10$LUeJLrtKr7pjMQYwlhRl8uxxXH/NggORs2JUfMBSi1Q0.9.o8iOya', NOW());
INSERT INTO tb_users (name, email, password, created_At) VALUES ('Julio Augusto', 'julio@gmail.com', '$2a$10$ik6njGRtmJo6QsKIOro/HutdFRzEyN62FnOv152wNEiweHGf2KEqe', NOW());
INSERT INTO tb_users (name, email, password, created_At) VALUES ('Renato Silva', 'renato@gmail.com', '$2a$10$0CPfcV3EeSQqmhsYLWUChehrhk0bsRGQzMvPEw/dLfCgTn3ffiOYS', NOW());

INSERT INTO tb_game_reviews (comment, moment, score, title, platform_id, author_id) VALUES ('Achei o crash 4 muito desafiador e adorei essa experiência, gostei muito da nova jogabilidade', now(), 10, 'Super Recomendo!', 1, 1);
INSERT INTO tb_game_reviews (comment, moment, score, title, platform_id, author_id) VALUES ('Muito dasafiador, não gostei', now(), 5, 'Não Gostei!', 2, 2);
INSERT INTO tb_game_reviews (comment, moment, score, title, platform_id, author_id) VALUES ('Uma experiêcia muito equilibrada com cenários bonitos', now(), 8, 'Cenários de ótima qualidade', 2, 3);
