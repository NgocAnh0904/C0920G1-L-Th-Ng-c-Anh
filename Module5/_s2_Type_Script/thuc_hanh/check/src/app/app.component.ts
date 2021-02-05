import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public name : string = 'leuleu';
  public imgLink : string = "https://daubepgiadinh.vn/wp-content/uploads/2018/04/hinh-banh-tiramisu-600x400.jpg";
  public tbBorder : number = 1;
  public isBorder : boolean = true;


  constructor() {}

  ngOnInit(): void {
  }
}
