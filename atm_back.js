const calculator = {
    displayValue: '0',
    firstOperand: null,
    waitingForSecondOperand: false,
    operator: null,
  };

  function inputDigit(digit) {
    const {
      displayValue,
      waitingForSecondOperand
    } = calculator;

    if (waitingForSecondOperand === true) {
      calculator.displayValue = digit;
      calculator.waitingForSecondOperand = false;
    } else {
      calculator.displayValue = displayValue === '0' ? digit : displayValue + digit;
    }
  }

  function resetCalculator() {
    calculator.displayValue = '0';
    calculator.firstOperand = null;
    calculator.waitingForSecondOperand = false;
    calculator.operator = null;
  }

  function updateDisplay() {
    const display = document.querySelector('.calculator-screen');
    display.value = calculator.displayValue;
  }

  updateDisplay();

  const keys = document.querySelector('.calculator-keys');
  keys.addEventListener('click', (event) => {
    const {
      target
    } = event;
    if (!target.matches('button')) {
      return;
    }

    if (target.classList.contains('all-clear')) {
      resetCalculator();
      updateDisplay();
      return;
    }

    inputDigit(target.value);
    updateDisplay();
  });