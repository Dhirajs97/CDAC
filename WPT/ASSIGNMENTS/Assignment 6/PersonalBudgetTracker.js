const expenses = [];
let totalExpense = 0;

const addExpense = (description, amount, date = new Date()) => {
    expenses.push({ description, amount, date });
    updateTotal(amount, () => console.log("Expense added successfully"));
};

const displayAllExpenses = () => {
    console.log("All Expenses:");
    expenses.forEach(({ description, amount, date }) => {
        console.log(`Description: ${description}`);
        console.log(`Amount: $${amount}`);
        console.log(`Date: ${date.toDateString()}`);
    });
}

const displayTotalExpenses = () => {
    const total = expenses.reduce((acc, expense) => acc + expense.amount, 0);
    console.log(`Total Expenses: $${total}`);
}

const displayDescriptions = () => {
    const descriptions = expenses.map(expense => expense.description);
    console.log("Expense Descriptions:", descriptions);
}

const displayExpensesAbove = (minAmount) => {
    const filteredExpenses = expenses.filter(expense => expense.amount > minAmount);
    console.log(`Expenses above ${minAmount}:`, filteredExpenses);
}

const addMultipleExpenses = (...newExpenses) => {
    expenses.push(...newExpenses);
    newExpenses.forEach(expense => updateTotal(expense.amount));
};


function updateTotal(amount, callback) {
    totalExpense += amount;
    if (callback) callback();
}


const fetchInitialExpenses = () => {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve([
                { description: 'Groceries', amount: 3000, date: new Date('2023-11-01') },
                { description: 'Petrol', amount: 1000, date: new Date('2023-11-02') }
            ]);
        }, 1000);
    });
};


const totalExpenseTracker = (() => {
    let total = 0;
    return {
        add: (amount) => total += amount,
        getTotal: () => total
    };
})();


async function initializeExpenses() {
    const initialExpenses = await fetchInitialExpenses();
    addMultipleExpenses(...initialExpenses);
    console.log("Initial expenses loaded:", initialExpenses);
    displayAllExpenses();
}


addExpense('Groceries', 5000, new Date('2023-11-03'));
addExpense('Petrol', 2000, new Date('2023-11-04'));
displayAllExpenses();
displayTotalExpenses();
displayDescriptions();
displayExpensesAbove(2000);
initializeExpenses();
