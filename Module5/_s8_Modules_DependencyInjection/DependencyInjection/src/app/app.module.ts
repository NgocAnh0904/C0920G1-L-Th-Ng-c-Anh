import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {ImageGalleryModule} from "./thuc_hanh/image-gallery/image-gallery/image-gallery.module";
import {GalleryConfig} from "./thuc_hanh/image-gallery/image-gallery/token";
import {ImgSliderModule} from './thuc_hanh/image-gallery/img-slider/img-slider.module';


@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        ImageGalleryModule,
        ImgSliderModule,
    ],
  providers: [
    {provide: GalleryConfig, useValue: 2}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
