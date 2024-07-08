<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .calculator {
            width: 200px;
            height: 300px;
            margin: 100px auto;
            padding: 20px;
            border-radius: 5px;
            background-color: #f7f7f7;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .calculator input[type="text"] {
            width: 100%;
            height: 40px;
            margin-bottom: 10px;
            text-align: right;
            padding-right: 10px;
            font-size: 24px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .calculator button {
            width: 45px;
            height: 45px;
            margin: 5px;
            font-size: 18px;
            border: 1px solid #ccc;
            border-radius: 3px;
            background-color: #fff;
            cursor: pointer;
        }
        .calculator button:hover {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
    <div class="calculator">
        <form action="calculate" method="post">
            <input type="text" name="display" id="display" readonly>
            <div>
                <button type="button" onclick="clearDisplay()">C</button>
                <button type="button" onclick="appendToDisplay('/')">/</button>
                <button type="button" onclick="appendToDisplay('*')">*</button>
                <button type="button" onclick="appendToDisplay('-')">-</button>
            </div>
            <div>
                <button type="button" onclick="appendToDisplay('7')">7</button>
                <button type="button" onclick="appendToDisplay('8')">8</button>
                <button type="button" onclick="appendToDisplay('9')">9</button>
                <button type="button" onclick="appendToDisplay('+')">+</button>
            </div>
            <div>
                <button type="button" onclick="appendToDisplay('4')">4</button>
                <button type="button" onclick="appendToDisplay('5')">5</button>
                <button type="button" onclick="appendToDisplay('6')">6</button>
                <button type="submit" name="operator" value="=">=</button>
            </div>
            <div>
                <button type="button" onclick="appendToDisplay('1')">1</button>
                <button type="button" onclick="appendToDisplay('2')">2</button>
                <button type="button" onclick="appendToDisplay('3')">3</button>
                <button type="button" onclick="appendToDisplay('0')">0</button>
            </div>
            <div>
                <button type="button" onclick="appendToDisplay('.')">.</button>
            </div>
        </form>
    </div>
    <script>
        function appendToDisplay(value) {
            document.getElementById('display').value += value;
        }
        function clearDisplay() {
            document.getElementById('display').value = '';
        }
    </script>
</body>
</html>
