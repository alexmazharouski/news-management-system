CREATE TABLE comment
(
    id SERIAL PRIMARY KEY NOT NULL,
    message TEXT,
    userid INT,
    newid INT
);
CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(30),
);
CREATE TABLE news
(
    id SERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    date DATE,
    article TEXT,
);
INSERT INTO news (title, date, article)
VALUES
('News 2', '2020-05-11', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin vestibulum quis tellus vitae cursus. In ut felis posuere quam varius.'),
('News 4', '2019-05-05', 'Nulla diam lectus, scelerisque vitae scelerisque et, ultrices vitae ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra.'),
('News 5', '2012-06-18', 'Cras egestas mattis massa, et ultricies libero tempus id. Vivamus auctor viverra posuere. Morbi cursus neque nec dictum ullamcorper. Sed.'),
('News 6', '2016-04-18', 'Donec eget euismod ipsum. Mauris quis libero faucibus, vulputate odio non, efficitur diam. Nam lectus risus, imperdiet ut aliquet sit.'),
('News 7', '2018-10-27', 'Vivamus laoreet massa ac mi blandit consectetur. Vestibulum viverra, ante id lacinia fringilla, urna odio condimentum turpis, ut varius ex.'),
('News 8', '2015-02-26', 'Aenean mauris enim, efficitur a nisl ac, egestas finibus ex. Pellentesque id ante id metus accumsan elementum ac vulputate urna.'),
('News 9', '2013-05-20', 'Proin vel maximus sem, eget molestie orci. Proin metus nunc, eleifend sit amet vestibulum vel, convallis non dolor. Nullam at.'),
('News 10', '2017-06-23', 'Vestibulum mi velit, finibus ac fringilla et, convallis sit amet leo. Nulla facilisi. Nulla condimentum erat vel justo accumsan, sed.'),
('News 11', '2010-07-02', 'Nam vitae arcu lorem. Nam vitae elementum leo. Morbi porttitor aliquet laoreet. Nunc ante eros, fermentum pharetra nibh id, egestas.'),
('News 12', '2016-09-18', 'Cras pretium tincidunt nisi non dignissim. Praesent tincidunt placerat feugiat. Fusce venenatis efficitur sem, at maximus eros auctor nec. Lorem.'),
('News 13', '2014-01-01', 'Duis imperdiet sagittis nulla vitae mollis. Etiam pretium massa a odio ullamcorper, sed vulputate lorem aliquam. Ut a lorem id.'),
('News 14', '2016-11-08', 'Sed id ligula sagittis, hendrerit nisl ut, fermentum sapien. Praesent tempus velit risus, a iaculis nunc mollis quis. Duis vestibulum.'),
('News 15', '2019-02-16', 'Fusce sit amet tortor aliquam, commodo augue sed, tristique nisl. Sed a congue nulla, volutpat imperdiet nulla. Proin turpis tortor.'),
('News 16', '2012-03-06', 'Maecenas semper rutrum leo, ac molestie ex tempus at. Praesent quis diam convallis, congue dolor quis, porta diam. Aenean auctor.'),
('News 17', '2010-03-02', 'Fusce in maximus nunc, nec tempor libero. Etiam bibendum volutpat sapien sit amet sollicitudin. Sed velit justo, auctor ultricies iaculis.');

INSERT INTO users (username)
VALUES
('Agallint'),
('Betaiezi'),
('Tysaimyl'),
('Tiealuis'),
('Osoceery'),
('Qurshata'),
('Zimastal'),
('Dialanie'),
('Prearase'),
('Nenwahry');

INSERT INTO comment (message, usersid, newsid)
VALUES
('Proin eget fringilla.', 1, 1),
('Nunc mollis leo.', 1, 2),
('Lorem ipsum dolor.', 1, 3),
('Morbi suscipit massa', 1, 4),
('massa tempus', 2, 5),
('metus interdum', 2, 6),
('Proin auctor magna', 2, 7),
('vel turpis accumsan', 2, 8),
('vel sodales massa', 3, 9),
('Nam volutpat orc', 3, 10),
('rhoncus vehicula mi cursus.', 3, 11),
('Nam commodo luctus felis', 3, 12),
(' eget ultricies ex tempor', 4, 13),
('Donec eget mauris dolor', 4, 14),
('Donec lobortis ullamcorper', 4, 15),
('quis ultrices turpis placerat', 4, 16),
('quis ultrices turpis placerat', 5, 15),
('nibh metus, et faucibus', 5, 14),
('lectus pulvinar tempor', 5, 13),
('Curabitur ut faucibus nunc', 5, 12),
('Suspendisse potenti', 6, 11),
(' Phasellus pellentesque', 6, 10),
('nisl vel feugiat dapibus', 6, 9),
('dui risus suscipit lacus', 6, 8),
('ut suscipit ante nisi non magna', 7, 7),
(' In varius enim laoreet dolor', 7, 6),
('Nam vehicula justo vitae turpis', 7, 5),
('fringilla malesuada', 7, 4),
('Suspendisse tempor eget mi ', 8, 3),
(' Donec et egestas tellus', 8, 2),
('Praesent interdum, arcu porta', 8, 1),
('finibus congue', 8, 2),
('dolor ligula fringilla nis', 9, 3),
('non vestibulum ligula nunc ', 9, 4),
('Vestibulum dictum consectetur', 9, 5),
('Fusce diam lorem', 9, 6),
(' tincidunt id lorem a, ullamcorper', 10, 7),
('Vestibulum mattis, mi a venenatis aliquam', 10, 8),
('justo lorem elementum augue', 10, 9),
('Proin pharetra enim sit amet', 1, 10),
('Praesent rutrum mi id lorem', 2, 11),
('id ultrices ipsum efficitur', 3, 12),
('Morbi ut eros eu massa', 4, 13),
('Ut tincidunt lacus ut mauris', 5, 14),
('ac mattis lacus efficitur', 6, 15),
('Donec lobortis auctor dapibus', 6, 16),
('Aliquam vitae porta felis, nec euismod elit', 7, 15);
