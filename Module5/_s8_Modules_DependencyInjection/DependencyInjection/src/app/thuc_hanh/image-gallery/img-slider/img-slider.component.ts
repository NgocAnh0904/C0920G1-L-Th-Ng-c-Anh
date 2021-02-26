import { Component, OnInit, ViewEncapsulation, ContentChildren, QueryList, AfterContentInit } from '@angular/core';
import { ImgSlideComponent } from './img-slide/img-slide.component';

@Component({
  selector: 'app-img-slider',
  templateUrl: './img-slider.component.html',
  styleUrls: ['./img-slider.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class ImgSliderComponent implements OnInit, AfterContentInit {
  @ContentChildren(ImgSlideComponent) slides: QueryList<ImgSlideComponent> | undefined;
  // @ts-ignore
  component;
  activeIndex = 0;
  constructor() { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
  }

  // tslint:disable-next-line:typedef
  ngAfterContentInit() {
    console.log(this.slides);
    // @ts-ignore
    this.component = this.slides.first;
  }

  // tslint:disable-next-line:typedef
  previos() {
    if (this.activeIndex > 0) {
      this.activeIndex--;
    }
    // @ts-ignore
    this.component = this.slides.toArray()[this.activeIndex];
  }
  // tslint:disable-next-line:typedef
  next() {
    // @ts-ignore
    if (this.activeIndex < this.slides.length - 1) {
      this.activeIndex++;
    }
    // @ts-ignore
    this.component = this.slides.toArray()[this.activeIndex];
  }

}
