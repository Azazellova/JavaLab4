<h1>Лабораторная работа №4</h1>
<h2>
  <p>Мазур София</p>
  <p>7 группа</p>
  <p>1 вариант</p>
</h2>

<h2>
  <p>Задание 1.2</p>
	<p>Без null</p>
</h2>
        <ul> 
          <li>Может хранить один произвольный объект в один момент времени</li> 
          <li>Хранилище неизменяемо</li> 
          <li>Объект кладется в Хранилище при его создании. В качестве объекта может быть сохранено также и значение null</li>                  <li>Хранилище может вернуть ссылку на Объект</li> <li>Если вместо объекта хранится null, необходимо вернуть какое-либо альтернативное значение</li> 
          <li>Метод получения значения должен работать с тем типом данных, который был указан во время создания объекта</li> </ul><h2>Выполните следующие задания:</h2> 
          <ul> 
            <li>Создайте Хранилище чисел, положите туда значение null. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть число 0</li> 
            <li>Создайте Хранилище чисел, положите туда значение 99. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должно быть число -1</li> 
            <li>Создайте Хранилище строк, положите туда значение null. Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть строка "default"</li> 
            <li>Создайте Хранилище строк, положите туда значение "hello". Передайте Хранилище в какой-либо метод, извлеките значение, и выведите его на экран. Альтернативой должна быть строка "hello world"</li> 
          </ul>
Класс Storage<T> представляет собой универсальное хранилище для объектов любого типа с механизмом обработки null-значений.

<h2>Структура класса</h2>
<h3>Поля класса</h3> 
<ul> 
  <li><code>private final T value</code> - основное значение для хранения</li> 
  <li><code>private final T altValue</code> - альтернативное значение, используемое когда основное равно `null`</li> 
</ul>
<h3>Конструктор</h3>
<pre><code>public Storage(T value, T altValue) { 
  this.value = value; 
	this.altValue = altValue; 
}</code>
</pre> 
<p>Конструктор инициализирует оба поля класса. Оба параметра могут принимать значение `null`.</p>

<h2>Методы класса</h2>

<h3>Метод getValue()</h3> 
<pre><code>public T getValue() { 
	if (value != null) { 
		return value; 
	} else { 
		return altValue; 
	} 
}</code>
</pre>
<h4>Алгоритм работы:</h4> 
<ol> 
  <li>Проверяется условие <code>value != null</code></li> 
  <li>Если условие истинно: 
    <ul> 
      <li>Метод возвращает основное значение <code>value</code></li> 
    </ul> 
  </li> 
  <li>Если условие ложно: 
    <ul> 
      <li>Метод возвращает альтернативное значение <code>altValue</code>
      </li> 
    </ul> 
  </li> 
</ol>
<h4>Особенности:</h4> 
<ul> 
  <li>Гарантирует, что метод никогда не вернет null из основного значения</li> 
  <li>Если оба значения равны null, метод вернет null из альтернативного значения</li> 
  <li>Возвращаемый тип соответствует параметру generic-типа T </li> 
</ul>

<h3>Метод printValue()</h3> 
<pre><code>public void printValue() { 
	System.out.println("Извлеченное значение: " + getValue()); 
}</code>
</pre>
<h4>Алгоритм работы:</h4> 
<ol> 
  <li>Вызывает метод <code>getValue()</code> для получения текущего значения</li> 
  <li>Форматирует строку вывода с префиксом "Извлеченное значение: "</li> 
  <li>Выводит результат в стандартный поток вывода</li> 
</ol>

<h3>Метод toString()</h3> 
<pre><code>@Override public String toString() { 
	return "Storage{value=" + value + ", alternative=" + altValue + "}"; 
} 
</code></pre>
<h4>Алгоритм работы:</h4> 
<ol> 
  <li>Форматирует строку с информацией о состоянии объекта</li> 
  <li>Включает в вывод оба поля: <code>value</code> и <code>altValue</code></li> 
  <li>Автоматически вызывает <code>toString()</code> для объектов, хранящихся в полях</li> 
</ol>
<h2>Принцип работы класса</h2>
<h3>Инициализация:</h3> 
<ol> 
  <li>Создается объект с указанием основного и альтернативного значений</li> 
  <li>Оба значения сохраняются в final-полях (неизменяемость)</li> 
</ol>
<h3>Получение значения:</h3> 
<ol> 
  <li>При вызове <code>getValue()</code> проверяется основное значение на null</li> 
  <li>Если основное значение не null - возвращается оно</li> 
  <li>Если основное значение null - возвращается альтернативное значение</li> 
</ol>
<h2>Примеры тестирования класса Хранилище</h2>
В программе реализованы подобные тесты с вводом данных в консоль.

<h3>Тест 1: Хранилище чисел с null значением</h3>
<ul>
<li><strong>Создание хранилища:</strong> <code>Storage&lt;Integer&gt; storage = new Storage&lt;&gt;(null, 0);</code></li>
<li><strong>Основное значение:</strong> null</li>
<li><strong>Альтернативное значение:</strong> 0</li>
<li><strong>Ожидаемый результат:</strong> При извлечении значения должно вернуться 0</li>
<li><strong>Проверка:</strong> <code>storage.getValue()</code> должно вернуть 0</li>
</ul>

<h3>Тест 2: Хранилище чисел со значением 99</h3>
<ul>
<li><strong>Создание хранилища:</strong> <code>Storage&lt;Integer&gt; storage = new Storage&lt;&gt;(99, -1);</code></li>
<li><strong>Основное значение:</strong> 99</li>
<li><strong>Альтернативное значение:</strong> -1</li>
<li><strong>Ожидаемый результат:</strong> При извлечении значения должно вернуться 99</li>
<li><strong>Проверка:</strong> <code>storage.getValue()</code> должно вернуть 99</li>
</ul>

<h3>Тест 3: Хранилище строк с null значением</h3>
<ul>
<li><strong>Создание хранилища:</strong> <code>Storage&lt;String&gt; storage = new Storage&lt;&gt;(null, "default");</code></li>
<li><strong>Основное значение:</strong> null</li>
<li><strong>Альтернативное значение:</strong> "default"</li>
<li><strong>Ожидаемый результат:</strong> При извлечении значения должно вернуться "default"</li>
<li><strong>Проверка:</strong> <code>storage.getValue()</code> должно вернуть "default"</li>
</ul>

<h3>Тест 4: Хранилище строк со значением "hello"</h3>
<ul>
<li><strong>Создание хранилища:</strong> <code>Storage&lt;String&gt; storage = new Storage&lt;&gt;("hello", "hello world");</code></li>
<li><strong>Основное значение:</strong> "hello"</li>
<li><strong>Альтернативное значение:</strong> "hello world"</li>
<li><strong>Ожидаемый результат:</strong> При извлечении значения должно вернуться "hello"</li>
<li><strong>Проверка:</strong> <code>storage.getValue()</code> должно вернуть "hello"</li>
</ul>





<h2> 
	<p>Задание 1.5</p> 
	<p>Обобщенная линия</p>
</h2>
<h3><p>Модификация класса Line для работы с двухмерными и трехмерными точками</p> </h3>
<ul> 
	<li>При создании объекта линии можно точно указать тип точки: двухмерная или трехмерная</li> 
	<li>Методы получения и установки значения точки работают с типом указанным при создании объекта</li> 
	<li>Граница стирания не может быть хуже двумерной точки</li> 
	<li>Создать и вывести на экран произвольную линию в трехмерном пространстве</li> 
</ul>
<h2>Структура решения</h2>
<h3>Иерархия классов точек</h3>
<h4>Абстрактный класс Point</h4> 
<ul> 
	<li><code>protected double x</code> - координата X</li> 
	<li><code>protected double y</code> - координата Y</li> 
	<li><code>public Point(double x, double y)</code> - конструктор с проверкой на NaN</li> 
	<li>Базовые геттеры и сеттеры для координат</li> 
	<li>Абстрактные методы <code>toString()</code>, <code>equals()</code>, <code>hashCode()</code></li> 
</ul>
<h4>Класс Point2D</h4> 
<ul> 
	<li>Наследует от <code>Point</code></li> 
	<li><code>public Point2D(double x, double y)</code> - конструктор двухмерной точки</li> 
	<li>Реализация <code>toString()</code> в формате "{x, y}"</li> 
</ul>
<h4>Класс Point3D</h4> 
<ul> 
	<li>Наследует от <code>Point2D</code></li> 
	<li><code>private double z</code> - координата Z</li> 
	<li><code>public Point3D(double x, double y, double z)</code> - конструктор трехмерной точки</li> 
	<li>Геттер и сеттер для координаты Z</li> 
	<li>Реализация <code>toString()</code> в формате "{x, y, z}"</li> 
	<li>Переопределенные <code>equals()</code> и <code>hashCode()</code> с учетом координаты Z</li> 
</ul>
<h3>Обобщенный класс Line</h3>
<h4>Объявление класса</h4> 
<pre><code>public class Line&lt;T extends Point&gt;</code></pre> 
<ul> 
	<li><code>T extends Point</code> - типовая переменная с ограничением, гарантирующая что T будет как минимум Point</li> 
	<li>Обеспечивает выполнение требования: "Граница стирания не может быть хуже двумерной точки"</li> 
</ul>
<h4>Поля класса</h4> 
<ul> 
	<li><code>private T startPoint</code> - начальная точка линии типа T</li> 
	<li><code>private T endPoint</code> - конечная точка линии типа T</li> 
</ul>


<h2>Конструкторы</h2>

<h3>Конструктор по умолчанию</h3> 
<pre><code>public Line() { 
	this.startPoint = (T) new Point2D(0, 0); 
	this.endPoint = (T) new Point2D(0, 0); 
}</code></pre> 
<ul> <li>Создает линию с двумерными точками по умолчанию</li> 
	<li>Приведение типа безопасно благодаря ограничению <code>T extends Point</code></li> 
</ul>

<h3>Конструктор с точками</h3> 
<pre><code>public Line(T startPoint, T endPoint) { 
	setStartPoint(startPoint); 
	setEndPoint(endPoint); 
}</code></pre> 
<ul>
	<li>Принимает точки указанного типа T</li> 
	<li>Выполняет требование: "При создании объекта можно указать тип точки"</li> 
	<li>Вызывает сеттеры для валидации точек</li> 
</ul>

<h3>Конструктор копирования</h3> 
<pre><code>public Line(Line&lt;T&gt; line) { 
	if (line == null) { 
		throw new InvalidLineException("Линия не может быть null"); 
	} 
	this.startPoint = line.startPoint; 
	this.endPoint = line.endPoint; 
}</code></pre> 
<ul> <li>Создает копию существующей линии</li> 
	<li>Проверяет исходную линию на null</li> 
</ul>

<h2>Методы получения точек</h2>

<h3>Метод getStartPoint()</h3> 
<pre><code>public T getStartPoint() { 
	return startPoint; 
}</code></pre> 
<ul> 
	<li>Возвращает начальную точку типа T</li> 
	<li>Выполняет требование: "Методы получения работают с типом указанным при создании"</li> 
</ul>
<h3>Метод getEndPoint()</h3> 
<pre><code>public T getEndPoint() { 
	return endPoint; 
}</code></pre> 
<ul> 
	<li>Возвращает конечную точку типа T</li> 
	<li>Гарантирует типобезопасность - возвращает именно тот тип, который был указан при создании</li> 
</ul>

<h2>Методы установки точек</h2>
<h3>Метод setStartPoint()</h3> 
<pre><code>public void setStartPoint(T startPoint) { 
	if (startPoint == null) { 
	throw new IllegalArgumentException("Начальная точка не может быть null"); 
	} 
	this.startPoint = startPoint; 
	validatePoints(); 
}</code></pre> 
<ul> 
	<li>Принимает точку типа T</li> 
	<li>Выполняет требование: "Методы установки работают с типом указанным при создании"</li> 
	<li>Проверяет точку на null</li> <li>Вызывает валидацию после установки</li> 
</ul>

<h3>Метод setEndPoint()</h3> 
<pre><code>public void setEndPoint(T endPoint) { 
	if (endPoint == null) { 
	throw new IllegalArgumentException("Конечная точка не может быть null"); 
	} 
	this.endPoint = endPoint; 
	validatePoints(); 
}</code></pre> 
<ul> 
	<li>Аналогичен setStartPoint()</li>
	<li>Гарантирует, что устанавливается точка правильного типа</li> 
</ul>

<h2>Вспомогательные методы</h2>
<h3>Метод validatePoints()</h3> 
<pre><code>private void validatePoints() { 
	if (startPoint.equals(endPoint)) { 
	throw new InvalidLineException("Начальная и конечная точки не могут совпадать"); 
	} 
}</code></pre> 
<ul> 
	<li>Проверяет, что начальная и конечная точки не совпадают</li> 
	<li>Использует метод equals() точек</li> 
</ul>
<h3>Метод getDistance()</h3> 
<pre><code>public double getDistance() { 
	double deltaX = endPoint.getX() - startPoint.getX(); 
	double deltaY = endPoint.getY() - startPoint.getY(); 
	return Math.sqrt(deltaX * deltaX + deltaY * deltaY); 
}</code></pre> 
<ul> 
	<li>Вычисляет расстояние между точками в проекции на плоскость XY</li> 
	<li>Работает с любым типом точки благодаря наличию методов getX() и getY() в базовом классе Point</li> 
</ul>
<h2>Методы Object</h2>
<h3>Метод toString()</h3> 
<pre><code>@Override public String toString() { 
	return "Линия от " + startPoint + " до " + endPoint; 
}</code></pre> 
<ul> 
	<li>Возвращает строковое представление линии</li> 
	<li>Использует toString() точек</li> 
</ul>
<h3>Метод equals()</h3> 
<pre><code>@Override public boolean equals(Object o) { 
	if (this == o) {
		return true; 
	}
	if (o == null || getClass() != o.getClass()) {
		return false; Line&lt;?&gt; 
	}
	line = (Line&lt;?&gt;) o; 
	return (startPoint.equals(line.startPoint) && endPoint.equals(line.endPoint)) 
			|| (startPoint.equals(line.endPoint) && endPoint.equals(line.startPoint)); 
}</code></pre> 
<ul> 
	<li>Сравнивает линии с учетом того, что линия A→B равна линии B→A</li> 
	<li>Использует wildcard <?> для сравнения линий разных параметризаций</li> 
</ul>
<h3>Класс InvalidLineException</h3> 
<ul> 
	<li>Наследует от <code>RuntimeException</code></li> 
	<li>Используется для обработки ошибок связанных с некорректными линиями</li> 
</ul>
<h2>Алгоритм работы программы</h2>
<h3>Инициализация системы</h3> 
<ol> 
	<li>Загружаются классы Point, Point2D, Point3D, Line, InvalidLineException</li> 
	<li>Компилятор проверяет корректность использования обобщенных типов</li> 
</ol>
<h3>Создание линии в трехмерном пространстве</h3> 
<ol> 
	<li>Создается объект Point3D для начальной точки с координатами (1.0, 2.0, 3.0)</li> 
	<li>Создается объект Point3D для конечной точки с координатами (4.0, 5.0, 6.0)</li> 
	<li>Создается объект Line&lt;Point3D&gt; с указанными точками</li> 
	<li>Конструктор Line проверяет точки на null и совпадение</li> 
	<li>Объект линии сохраняет ссылки на точки</li> 
</ol>
<h3>Вывод линии на экран</h3> 
<ol> 
	<li>Вызывается метод toString() объекта Line</li> 
	<li>Line.toString() вызывает toString() для начальной и конечной точек</li> 
	<li>Point3D.toString() возвращает строку в формате "{x, y, z}"</li> 
	<li>Формируется итоговая строка: "Линия от {1.0, 2.0, 3.0} до {4.0, 5.0, 6.0}"</li> 
	<li>Строка выводится в консоль</li> 
</ol>
<h3>Работа с методами получения и установки</h3> 
<ol> 
	<li>При вызове getStartPoint() возвращается объект типа Point3D</li> 
	<li>При вызове setStartPoint() принимается только Point3D</li> 
	<li>Компилятор предотвращает установку точек несовместимого типа</li> 
</ol>

<h2>Примеры использования</h2>
<h3>Создание и вывод трехмерной линии</h3> 
<pre><code>Point3D start3D = new Point3D(1.0, 2.0, 3.0); 
Point3D end3D = new Point3D(4.0, 5.0, 6.0); 
Line&lt;Point3D&gt; line3D = new Line&lt;&gt;(start3D, end3D); 
System.out.println("Трехмерная линия: " + line3D);
</code></pre>
<h3>Создание и вывод двумерной линии</h3> 
<pre><code>Point2D start2D = new Point2D(1.0, 1.0); 
Point2D end2D = new Point2D(4.0, 5.0); 
Line&lt;Point2D&gt; line2D = new Line&lt;&gt;(start2D, end2D); 
System.out.println("Двухмерная линия: " + line2D);</code>
</pre>

<h2>
  <p>Задание 2.1</p>
  <p>Сдвинуть линию</p>
</h2>

<ul>
  <li>Создать метод, принимающий Линию из задачи 3.1.5 с любой допустимой параметризацией</li>
  <li>Метод должен сдвигать начальную точку линии на 10 единиц по оси X</li>
  <li>Например, если X был 5, то должен стать 15, если X был -7, то должен стать -17</li>
  <li>Использовать параметризацию, маски типов и их ограничения</li>
</ul>

<h2>Структура решения</h2>

<h3>Класс Line&lt;T extends Point&gt;</h3>
<ul>
  <li><code>private T startPoint</code> - начальная точка линии</li>
  <li><code>private T endPoint</code> - конечная точка линии</li>
</ul>

<h3>Параметризация и ограничения</h3>
<ul>
  <li>Тип <code>T extends Point</code> гарантирует, что линия может работать только с типами, наследующими от Point</li>
  <li>Ограничение <code>extends Point</code> обеспечивает наличие методов getX() и setX() у точек</li>
</ul>

<h2>Методы решения</h2>

<h3>Метод shiftLineX()</h3>
<pre><code>public void shiftLineX() {
	T start = this.getStartPoint();
	T end = this.getEndPoint();
	start.setX(start.getX() + 10);
	end.setX(end.getX() + 10);
}</code></pre>

<h4>Алгоритм работы:</h4>
<ol>
  <li>Получить начальную точку линии с помощью <code>getStartPoint()</code></li>
  <li>Получить конечную точку линии с помощью <code>getEndPoint()</code></li>
  <li>Вычислить новое значения координат X: <code>старт_X + 10</code> и <code>конеч_X + 10</code></li>
  <li>Установить новое значения координат X с помощью <code>setX(новое_значение)</code></li>
</ol>

<h3>Статический метод shiftLineStartX()</h3>
<pre><code>public static <U extends Point> void shiftLineStartX(Line<U> line) {
	if (line == null) {
		throw new IllegalArgumentException("Линия не может быть null");
	}
	U start = line.getStartPoint();
	U end = line.getEndPoint();
	start.setX(start.getX() + 10);
	end.setX(end.getX() + 10);
}</code></pre>

<h4>Алгоритм работы:</h4>
<ol>
  <li>Проверить, что переданная линия не равна null</li>
  <li>Получить начальную точку линии с помощью <code>getStartPoint()</code></li>
  <li>Получить конечную точку линии с помощью <code>getEndPoint()</code></li>
  <li>Вычислить новое значения координат X: <code>старт_X + 10</code> и <code>конеч_X + 10</code></li>
  <li>Установить новое значения координат X с помощью <code>setX(новое_значение)</code></li>
</ol>

<h2>Принцип работы параметризации</h2>

<h3>Ограничение типов &lt;T extends Point&gt;</h3>
<ul>
  <li>Гарантирует, что тип T является подтипом Point</li>
  <li>Обеспечивает безопасность типов при компиляции</li>
  <li>Позволяет использовать методы класса Point без явного приведения типов</li>
</ul>

<h3>Маски типов</h3>
<ul>
  <li>Используется ограниченная маска <code>? extends Point</code> для работы с любыми подтипами Point</li>
  <li>Позволяет методу работать с линиями любых типов точек, наследующих от Point</li>
</ul>

<h2>Примеры использования</h2>

<h3>Пример 1: Сдвиг линии с Point2D</h3>
<ul>
  <li><strong>Создание линии:</strong> <code>Line&lt;Point2D&gt; line = new Line&lt;&gt;(new Point2D(5, 3), new Point2D(10, 8));</code></li>
  <li><strong>Начальное состояние:</strong> Начальная точка (5, 3)</li>
  <li><strong>Вызов метода:</strong> <code>line.shiftStartPointX();</code></li>
  <li><strong>Конечное состояние:</strong> Начальная точка (15, 3)</li>
</ul>

<h3>Пример 2: Сдвиг линии с Point3D</h3>
<ul>
  <li><strong>Создание линии:</strong> <code>Line&lt;Point3D&gt; line = new Line&lt;&gt;(new Point3D(-7, 2, 4), new Point3D(1, 5, 9));</code></li>
  <li><strong>Начальное состояние:</strong> Начальная точка (-7, 2, 4)</li>
  <li><strong>Вызов метода:</strong> <code>Line.shiftLineStartX(line);</code></li>
  <li><strong>Конечное состояние:</strong> Начальная точка (-17, 2, 4)</li>
</ul>

<h3>Пример 3: Демонстрация полиморфизма</h3>
<ul>
  <li><strong>Обобщенный метод:</strong> 
    <pre><code>public static &lt;T extends Point&gt; void demonstrateShift(Line&lt;T&gt; line) {
    System.out.println("До сдвига: " + line);
    line.shiftStartPointX();
    System.out.println("После сдвига: " + line);
}</code></pre>
  </li>
  <li><strong>Работает с любым типом линии:</strong> Line&lt;Point2D&gt;, Line&lt;Point3D&gt; и другими наследниками Point</li>
</ul>
