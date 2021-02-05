import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FontSizeEditorComponent} from './thuc-hanh/font-size-editor/font-size-editor.component';
import {PetComponent} from './thuc-hanh/pet/pet.component';
import {BootrapAngularComponent} from './thuc-hanh/bootrap-angular/bootrap-angular.component';
import {FormsModule} from '@angular/forms';
import { CalculatorComponent } from './bai-tap/calculator/calculator.component';
import { ColorAngularComponent } from './bai-tap/color-angular/color-angular.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    BootrapAngularComponent,
    CalculatorComponent,
    ColorAngularComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
