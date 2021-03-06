# Tasks for Java training Web

## 1. Shapes 

Четырехугольник. Разработать классы Точка и Четырехугольник. Создать методы и тесты: 
* вычисления площади и периметра фигуры; 
* составляют ли точки четырехугольник(не лежат ли три точки на одной прямой); 
* является ли четырехугольник выпуклым; 
* является ли четырехугольник квадратом, ромбом, трапецией.

- Площади, Объемы, Периметры фигур должны храниться в объекте класса-Warehouse. 
- Любое изменение параметра фигуры должно вызывать пересчет соответствующих значений в классе- Warehouse.
- Для решения данной задачи использовать паттерны Observer и Singleton. 
- Все созданные объекты геометрических фигур сохранить в объекте-репозитории. 
- Используя шаблон Repository, разработать спецификации по добавлению, удалению и изменению объектов репозитория.
* Разработать спецификации по поиску объектов и групп объектов в репозитории. По ID, по имени, по координатам (например: найти все объекты точки которых находятся в первом квадранте, найти все объекты площади поверхности (объемы, периметры) которых заключены в заданный диапазон, найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат)
* Разработать методы сортировки наборов объектов по ID, по имени, по координатам Х первой точки, по координатам Y первой точки и т д. Использовать интерфейс Comparator.

## 2. Information handling

* Отсортировать абзацы по количеству предложений.
* Отсортировать слова в предложении по длине.
* Отсортировать предложения в абзаце по количеству слов.
* Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.

- Разобранный текст должен быть представлен в виде объекта, содержащего, например, абзацы, предложения, лексемы, слова, выражения, символы. Лексема – часть текста, ограниченная пробельными символами. Для организации структуры данных использовать паттерн Composite.
- Разобранный текст необходимо восстановить в первоначальном виде. Для деления текста на составляющие следует использовать регулярные выражения.
- Код, выполняющий разбиение текста на составляющие части, следует оформить в виде классов-парсеров с использованием паттерна Chain of Responsibility. При разработке парсеров, разбирающих текст, необходимо следить количеством создаваемых объектов-парсеров. Их не должно быть слишком много.

## 3. XML, XSD, Parsing

* XML parser Students

## 4. Multithreading

* Кальянная. Доступны несколько кальянов. Несколько посетителей (группа друзей) могут использовать один кальян. Кальян может использоваться одним посетителем. Группы друзей и одиночные посетители кому кальян не достался ожидают в очереди внутри помещения, а при недостатке мест, вне его.

- Разработать многопоточное приложение, использующее разделяемые ресурсы. Любая сущность, желающая получить доступ к разделяемому ресурсу, должна быть потоком.
