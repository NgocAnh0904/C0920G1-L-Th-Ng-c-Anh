class Person {
    first_name: string;
    last_name: string;
    age: number;

    constructor(first_name: string, last_name: string, age: number){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    greet() {
        console.log("Hello", this.first_name);
    }
}

var p: Person = new Person("CUT", "Code", 23);
p.greet();

