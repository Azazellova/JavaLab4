<h1>Лабораторная работа №4</h1>
<h2>
  <p>Мазур София</p>
  <p>7 группа</p>
  <p>1 вариант</p>
</h2>

<h2>
  <p>Задание 1.2 Без null</p>
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
	<p>Задание 1.5 Обобщенная линия</p> 
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
	<li><code>public Point(double x, double y)</code> - конструктор с проверкой на null</li> 
	<li>Базовые геттеры и сеттеры для координат</li> 
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
  <p>Задание 2.1 Сдвинуть линию</p>
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
  <li><strong>Вызов метода:</strong> <code>line.shiftLineX();</code></li>
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


<h2>
	<p>Задание 3.1 Функция</p>
</h2>

<h2>Структура решения</h2>
<h3>Основной класс FunctionApply</h3>
<h3>Основной преобразующий метод apply()</h3>
    <pre><code>public static &lt;T, P&gt; List&lt;P&gt; apply(List&lt;T&gt; list, Function&lt;T, P&gt; function){
	List&lt;P&gt; result = new ArrayList<>();
	for (T value : list) {
		result.add(function.apply(value));
	}
	return result;
}</code></pre>
<h4>Алгоритм работы:</h4>
	<ol>
		<li><strong>Инициализация результата:</strong> Создание нового пустого списка типа P</li>
		<li><strong>Итерация по элементам:</strong> Последовательный обход каждого элемента исходного списка
			<ul>
				<li>Для каждого элемента типа T применяется функция преобразования</li>
				<li>Результат функции (тип P) добавляется в результирующий список</li>
			</ul>
		</li>
		<li><strong>Возврат результата:</strong> Возврат заполненного списка преобразованных значений</li>
	</ol>
<h3>Ввода данных</h3>
<h4>Алгоритм inputStringList():</h4>
	<ol>
		<li>Запрос количества строк для ввода</li>
		<li>Очистка буфера сканера после чтения числа</li>
		<li>Циклический ввод указанного количества строк</li>
		<li>Возврат списка введённых строк</li>
	</ol>

<h4>Алгоритм inputIntegerList():</h4>
	<ol>
		<li>Запрос количества чисел для ввода</li>
		<li>Циклический ввод указанного количества целых чисел</li>
		<li>Очистка буфера сканера после завершения ввода</li>
		<li>Возврат списка введённых чисел</li>
	</ol>

<h4>Алгоритм inputArraysList():</h4>
	<ol>
		<li>Запрос количества массивов для ввода</li>
		<li>Для каждого массива:
			<ul>
				<li>Запрос размера массива</li>
				<li>Создание массива указанного размера</li>
				<li>Поэлементный ввод значений массива</li>
			</ul>
		</li>
		<li>Очистка буфера сканера</li>
		<li>Возврат списка массивов</li>
	</ol>

<h2>Конкретные реализации преобразований</h2>

<h3>Преобразование 1: Строки → Длины строк</h3>
	
<h4>Алгоритм:</h4>
	<ol>
		<li>Вызов inputStringList() для получения списка строк</li>
		<li>Применение метода apply() с функцией String::length
			<ul>
				<li><strong>Автовывод типов:</strong> T=String, P=Integer</li>
			</ul>
		</li>
		<li>Вывод исходных данных и результатов</li>
		<li>Детализированный вывод соответствия строк и их длин</li>
	</ol>

<h3>Преобразование 2: Числа → Абсолютные значения</h3>
	
<h4>Алгоритм:</h4>
	<ol>
		<li>Вызов inputIntegerList() для получения списка чисел</li>
		<li>Применение метода apply() с функцией Math::abs
			<ul>
				<li><strong>Автовывод типов:</strong> T=Integer, P=Integer</li>
			</ul>
		</li>
		<li>Вывод исходных данных и результатов</li>
		<li>Детализированный вывод преобразования чисел</li>
	</ol>

<h3>Преобразование 3: Массивы → Максимальные значения</h3>
	
<h4>Алгоритм:</h4>
	<ol>
		<li>Вызов inputArraysList() для получения списка массивов</li>
		<li>Применение метода apply() с лямбда-выражением для нахождения максимума
			<ul>
				<li><strong>Автовывод типов:</strong> T=int[], P=Integer</li>
			</ul>
		</li>
		<li>Вывод исходных массивов и максимальных значений</li>
		<li>Детализированный вывод соответствия массивов и их максимумов</li>
	</ol>

<h2>
  <p>Задача 3.2 Фильтры</p>
</h2>

<ul>
  <li>Предоставляет статический метод для фильтрации элементов коллекции по заданному условию</li>
  <li>Работает с любыми типами данных благодаря использованию дженериков</li>
  <li>Использует функциональный интерфейс Predicate для задания условий фильтрации</li>
  <li>Возвращает новую коллекцию, не изменяя исходную</li>
  <li>Поддерживает автовывод типов при использовании</li>
</ul>

<h2>Структура класса</h2>

<h3>Поля класса</h3>
<ul>
  <li>Класс не содержит полей</li>
</ul>

<h3>Метод test()</h3>
<pre><code>public static &lt;T&gt; List&lt;T&gt; test(List&lt;T&gt; list, Predicate&lt;T&gt; predicate) {
    List&lt;T&gt; result = new ArrayList&lt;&gt;();
    for (T value : list) {
        if (predicate.test(value)) result.add(value);
    }
    return result;
}</code></pre>

<h4>Алгоритм работы метода test():</h4>
<ol>
  <li><strong>Инициализация результата:</strong> Создается новый пустой ArrayList для хранения отфильтрованных элементов</li>
  <li><strong>Итерация по коллекции:</strong> Для каждого элемента в исходном списке выполняется:
    <ul>
      <li>Вызов метода <code>predicate.test(value)</code> с текущим элементом</li>
      <li>Проверка возвращаемого булевого значения</li>
    </ul>
  </li>
  <li><strong>Добавление элементов:</strong> Если условие возвращает true, элемент добавляется в результирующий список</li>
  <li><strong>Возврат результата:</strong> Метод возвращает новый список с отфильтрованными элементами</li>
</ol>

<h4>Параметры метода:</h4>
<ul>
  <li><code>List&lt;T&gt; list</code> - исходная коллекция для фильтрации</li>
  <li><code>Predicate&lt;T&gt; predicate</code> - условие фильтрации в виде функционального интерфейса</li>
</ul>

<h4>Возвращаемое значение:</h4>
<ul>
  <li><code>List&lt;T&gt;</code> - новая коллекция, содержащая только элементы, удовлетворяющие условию</li>
</ul>

<h2>Принцип работы класса</h2>

<h3>Обобщенное программирование (Generics):</h3>
<ol>
  <li>Параметр типа <code>&lt;T&gt;</code> позволяет методу работать с любым типом данных</li>
  <li>Компилятор обеспечивает типобезопасность на этапе компиляции</li>
  <li>Автовывод типов позволяет не указывать тип явно при вызове метода</li>
</ol>

<h3>Функциональный интерфейс Predicate:</h3>
<ul>
  <li>Определяет единственный метод <code>test(T t)</code>, возвращающий boolean</li>
  <li>Позволяет передавать условия фильтрации в виде лямбда-выражений</li>
</ul>

<h2>Примеры использования</h2>

<h3>Пример 1: Фильтрация строк по длине</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список строк: "qwerty", "asdfg", "zx"</li>
  <li><strong>Условие фильтрации:</strong> Оставить строки длиной 3 символа и менее</li>
  <li><strong>Реализация:</strong> 
    <pre><code>List&lt;String&gt; list1 = Validator.inputStringList(input);
int minLen = Validator.inputPositiveInteger(input,"Введите минимальную длину строки: ");
List<String> filteredList1 = Filter.test(list1, str -> str.length() < minLen);</code></pre>
  </li>
  <li><strong>Ожидаемый результат:</strong> ["zx"]</li>
</ul>

<h3>Пример 2: Фильтрация чисел по знаку</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список чисел: 1, -3, 7</li>
  <li><strong>Условие фильтрации:</strong> Оставить положительные числа (>= 0)</li>
  <li><strong>Реализация:</strong>
    <pre><code>List&lt;Integer&gt; Validator.inputIntegerList(input);
List&lt;Integer&gt; result = Filter.test(numbers, n -> n <= 0);</code></pre>
  </li>
  <li><strong>Ожидаемый результат:</strong> [1, 7]</li>
</ul>

<h3>Пример 3: Фильтрация массивов чисел</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список массивов: [-1, -2], [0, -5], [3, -1]</li>
  <li><strong>Условие фильтрации:</strong> Оставить массивы без положительных элементов</li>
  <li><strong>Реализация:</strong>
    <pre><code>List&lt;int[]&gt; list3 = Validator.inputArraysList(input);
List&lt;int[]&gt; negFilteredList3 = Filter.test(list3, arr -> {
   for (int num: arr) {
	   if (num >= 0) {
		   return false;
	   }
   }</code></pre>


<h2>
  <p>Задание 3.3 Сокращение</p>
  <p>Без null и исключений для пустого списка</p>
</h2>

<ul>
  <li>Преобразует список элементов в одно значение путем последовательного применения бинарной операции</li>
  <li>Гарантирует возврат корректного значения даже для пустого списка</li>
  <li>Использует начальное значение (identity) как основу для свертки</li>
  <li>Поддерживает любые типы данных через механизм дженериков</li>
  <li>Работает с любыми бинарными операциями, совместимыми с типом элементов</li>
</ul>

<h2>Структура метода</h2>

<h3>Сигнатура метода</h3>
<pre><code>public static &lt;T&gt; T reduce(List&lt;T&gt; list, T begin, BinaryOperator&lt;T&gt; union)</code></pre>

<h4>Параметры:</h4>
<ul>
  <li><code>List&lt;T&gt; list</code> - список элементов для свертки</li>
  <li><code>T begin</code> - начальное значение (нейтральный элемент операции)</li>
  <li><code>BinaryOperator&lt;T&gt; union</code> - бинарная операция для объединения элементов</li>
</ul>

<h4>Возвращаемое значение:</h4>
<ul>
  <li>Результат типа <code>T</code> - свернутое значение списка</li>
</ul>

<h2>Алгоритм работы метода</h2>

<h3>1. Проверка входных данных</h3>
<pre><code>if (list == null || list.isEmpty()) {
	return begin;
}</code></pre>
<ul>
  <li>Проверяется условие <code>list == null || list.isEmpty()</code></li>
  <li>Если условие истинно:
    <ul>
      <li>Метод немедленно возвращает начальное значение <code>begin</code></li>
      <li>Это гарантирует обработку null и пустых списков без исключений</li>
    </ul>
  </li>
  <li>Если условие ложно - алгоритм продолжает выполнение</li>
</ul>

<h3>2. Инициализация результата</h3>
<pre><code>T result = begin;</code></pre>
<ul>
  <li>Создается переменная <code>result</code> для хранения промежуточных результатов</li>
  <li>Инициализируется начальным значением <code>begin</code></li>
</ul>

<h3>3. Итерация по элементам списка</h3>
<pre><code>for (T value : list) result = union.apply(result, value);</code></pre>
<ul>
  <li>Для каждого элемента <code>value</code> в списке <code>list</code>:
    <ul>
      <li>Вызывается метод <code>union.apply(result, value)</code></li>
      <li>Текущий результат и элемент передаются в бинарную операцию</li>
      <li>Результат операции сохраняется в переменную <code>result</code></li>
    </ul>
  </li>
  <li>Процесс повторяется для всех элементов списка</li>
</ul>

<h3>4. Возврат результата</h3>
<pre><code>return result;</code></pre>
<ul>
  <li>После обработки всех элементов возвращается финальное значение <code>result</code></li>
</ul>

<h2>Примеры использования метода</h2>

<h3>Пример 1: Объединение строк</h3>
<ul>
  <li><strong>Исходные данные: Список: ["qwerty", "asdfg", "zx"]</li>
  <li><strong>Реализация:</strong> <pre><code>List&lt;String&gt; strings1 = Validator.inputStringList(input);
String concatenated = Decrease.reduce(strings1, "", (s1, s2) ->
		(s1 == null ? "" : s1) + (s2 == null ? "" : s2));</code></pre></li>
  <li><strong>Результат:</strong> <code>"qwertyasdfgzx"</code></li>
</ul>

<h3>Пример 2: Сумма чисел</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список [1, -3, 7]</code></li>
  <li><strong>Реализация:</strong> <pre><code>List&lt;Integer&gt; integers = Validator.inputIntegerList(input);
Integer sum = Decrease.reduce(integers, 0, (a, b) -> a + b);
System.out.println("Сумма чисел: " + sum);</code></pre></li>
  <li><strong>Результат:</strong> <code>5</code></li>
</ul>

<h3>Пример 3: Подсчет элементов вложенных списков</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список массивов: [1, 2, 3], [4, 5], [6, 7, 8, 9]</li>
  <li><strong>Реализация:</strong> <pre><code>List&lt;int[]&gt; listOfArrays = Validator.inputArraysList(input);
List<Integer> sizes = new ArrayList<>();
for (int[] array : listOfArrays) {
	sizes.add(array.length);
}</code></pre></li>
  <li><strong>Результат:</strong> <code>9</code></li>
</ul>


<h2>
	Задание 3.4 Коллекционирование
</h2>

<h3>Класс Collections</h3>
<h3>Назначение класса</h3>
<ul>
  <li>Предоставляет универсальный метод для фильтрации и сбора элементов списка в указанную коллекцию</li>
</ul>

<h2>Структура метода collect</h2>
<h3>Сигнатура метода</h3>
<pre><code>public static &lt;T, P extends Collection&lt;T&gt;&gt; P collect(
    List&lt;T&gt; list, 
    Supplier&lt;P&gt; collectionFactory, 
    Predicate&lt;T&gt; filter
)</code></pre>

<h3>Параметры метода</h3>
<ul>
  <li><code>List&lt;T&gt; list</code> - исходный список элементов для обработки</li>
  <li><code>Supplier&lt;P&gt; collectionFactory</code> - фабрика для создания результирующей коллекции</li>
  <li><code>Predicate&lt;T&gt; filter</code> - условие фильтрации элементов</li>
</ul>

<h2>Алгоритм работы метода</h2>
<ul>
  <li><strong>Создание коллекции:</strong>
    <ul>
      <li>Вызывается метод <code>collectionFactory.get()</code></li>
      <li>Создается пустая коллекция указанного типа</li>
    </ul>
  </li>
  
  <li><strong>Итерация по списку:</strong>
    <ul>
      <li>Для каждого элемента в исходном списке выполняется проверка</li>
      <li>Используется цикл for-each: <code>for (T value : list)</code></li>
    </ul>
  </li>
  
  <li><strong>Фильтрация элементов:</strong>
    <ul>
      <li>Для каждого элемента вызывается <code>filter.test(value)</code></li>
      <li>Если условие возвращает <code>true</code>, элемент добавляется в результирующую коллекцию</li>
      <li>Если условие возвращает <code>false</code>, элемент пропускается</li>
    </ul>
  </li>
  
  <li><strong>Добавление элемента:</strong>
    <ul>
      <li>Прошедшие фильтрацию элементы добавляются методом <code>result.add(value)</code></li>
    </ul>
  </li>
  
  <li><strong>Возврат результата:</strong>
    <ul>
      <li>После обработки всех элементов возвращается заполненная коллекция</li>
    </ul>
  </li>
</ul>

<h2>Примеры использования метода</h2>

<h3>Пример 1: Разделение чисел на положительные и отрицательные</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список: [1, -3, 7]</li>
  <li><strong>Реализация:</strong> 
    <pre><code>List&lt;Integer&gt; numbers = Validator.inputIntegerList(scanner);
List&lt;Integer&gt; positive = Collecting.collect(numbers, ArrayList::new, num -> num > 0);
List&lt;Integer&gt; negative = Collecting.collect(numbers, ArrayList::new, num -> num < 0);</code></pre>
  </li>
  <li><strong>Результат:</strong> 
    <ul>
      <li>Положительные: [1, 7]</li>
      <li>Отрицательные: [-3]</li>
    </ul>
  </li>
</ul>

<h3>Пример 2: Группировка строк по длине</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список: ["qwerty", "asdfg", "zx", "qw"]</li>
  <li><strong>Реализация:</strong> 
    <pre><code>Set<Integer> lengthsList5 = new HashSet<>();
for (String s : list5) {
	if (s != null) {
		lengthsList5.add(s.length());
	}
}

Map<Integer, List&lt;String&gt; colList5 = new HashMap<>();
for (Integer len : lengthsList5) {
	List&lt;String&gt; group = Collections.collect(list5, ArrayList::new,
			str -> str != null && str.length() == len);
	colList5.put(len, group);
}</code></pre>
  </li>
  <li><strong>Результат:</strong> 
    <ul>
      <li>Длина 2: ["zx", "qw"]</li>
      <li>Длина 5: ["asdfg"]</li>
      <li>Длина 6: ["qwerty"]</li>
    </ul>
  </li>
</ul>

<h3>Пример 3: Удаление дубликатов строк</h3>
<ul>
  <li><strong>Исходные данные:</strong> Список: ["qwerty", "asdfg", "qwerty", "qw"]</li>
  <li><strong>Реализация:</strong> 
    <pre><code>ListCollection&lt;String&gt; list6 = Validator.inputStringList(input);
Collection&lt;String&gt; colList6 = Collections.collect(list6, HashSet::new, str -> true);
</code></pre>
  </li>
  <li><strong>Результат:</strong> ["qwerty", "asdfg", "qw"]</li>
</ul>

