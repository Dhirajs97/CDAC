// Use the spread operator to merge two arrays of fruits.

arr1 = ['Apple', 'Grapes', 'Banana'];
arr2 = ['Pineapple', 'Orange']

arr = [...arr1, ...arr2]
console.log(arr);

arr2 = [...arr1, 'Pineapple', 'Orange'];
console.log(arr2);
