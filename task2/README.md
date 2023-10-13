Описание/Пошаговая инструкция выполнения домашнего задания:

В далекой звездной системе встретились две флотилии космических кораблей. Корабли могут передвигаться по всему пространству звездной системы по прямой, поворачиваться против и по часовой стрелке, стрелять фотонными торпедами. Попадание фотонной торпеды в корабль выводит его из строя.
От каждой флотилии в сражении принимают участие по три космических корабля.
Победу в битве одерживает та флотилия, которая первой выведет из строя все корабли соперника.
Управление флотилиями осуществляется игрокам компьютерными программами (то есть не с клавиатуры).
Концептуально игра состоит из трех подсистем:

1. Игровой сервер, где реализуется вся игровая логика.
2. Player - консольное приложение, на котором отображается конкретная битва.
3. Агент - приложение, которое запускает программу управления танками от имени игрока и отправляет управляющие команды на игровой сервер.
Реализовать движение объектов на игровом поле в рамках подсистемы Игровой сервер.

Критерии оценки:

За выполнение каждого пункта, перечисленного ниже начисляются баллы:

ДЗ сдано на проверку - 1 балл

Оформлен pull/merge request на github/gitlab - 1 балл

Настроен CI - 2 балла

Прямолинейное равномерное движение без деформации.
Само движение реализовано в виде отдельного класса - 1 балл.

Для движущихся объектов определен интерфейс, устойчивый к появлению новых видов движущихся объектов - 1 балл

Реализован тесты:
Для объекта, находящегося в точке (12, 5) и движущегося со скоростью (-7, 3) движение меняет положение объекта на (5, 8)

Попытка сдвинуть объект, у которого невозможно прочитать положение в пространстве, приводит к ошибке

Попытка сдвинуть объект, у которого невозможно прочитать значение мгновенной скорости, приводит к ошибке

Попытка сдвинуть объект, у которого невозможно изменить положение в пространстве, приводит к ошибке
1 балл

Поворот объекта вокруг оси.
Сам поворот реализован в виде отдельного класса - 1 балл

Для поворачивающегося объекта определен интерфейс, устойчивый к появлению новых видов движущихся объектов - 1 балл
Реализован тесты - 1 балл.