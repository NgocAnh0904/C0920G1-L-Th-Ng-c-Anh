var Person = /** @class */ (function () {
    function Person(first_name, last_name, age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }
    Person.prototype.greet = function () {
        console.log("Hello", this.first_name);
    };
    return Person;
}());
var p = new Person("ĐỒ NGU", "Code", 23);
p.greet();
