import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss']
})
export class PetComponent implements OnInit {
  petName = 'naruto';
  petImage = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQg3zE-sGZGHVs0G6yHHfoA0pOpjfUpxXKlfQ&usqp=CAU';

  constructor() {
  }

  ngOnInit(): void {
  }

  updateName(name:any) {
    this.petName = name;
  }

  updateImage(image:any) {
    this.petImage = image;
  }
}
