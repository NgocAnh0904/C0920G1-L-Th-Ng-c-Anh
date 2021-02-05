import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-angular',
  templateUrl: './color-angular.component.html',
  styleUrls: ['./color-angular.component.scss']
})
export class ColorAngularComponent implements OnInit {

  background = '#00e067';
  constructor() { }

  ngOnInit() {
  }

  onChange(value : any) {
    this.background = value;
  }

}
