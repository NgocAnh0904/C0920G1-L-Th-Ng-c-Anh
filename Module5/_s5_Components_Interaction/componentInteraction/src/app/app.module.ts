import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

// import { AppRoutingModule } from './app-routing.module';
// import { AppComponent } from './app.component';
import { NameCardComponent } from './thuc_hanh/name-card/name-card.component';
import { ProgressBarComponent } from './thuc_hanh/progress-bar/progress-bar.component';

import { AppComponent } from './app.component';
import { CountdownTimerComponent } from './bai_tap/countdown-timer/countdown-timer.component';
import { CountdownTimerGetSetComponent } from './bai_tap/countdown-timer-get-set/countdown-timer-get-set.component';
import { CountdownTimerOnchangesComponent } from './bai_tap/countdown-timer-onchanges/countdown-timer-onchanges.component';
import { CountdownTimerAliasComponent } from './bai_tap/countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerEventComponent } from './bai_tap/countdown-timer-event/countdown-timer-event.component';
import { CountdownTimerEventAliasComponent } from './bai_tap/countdown-timer-event-alias/countdown-timer-event-alias.component';
import { RatingBarComponent } from './bai_tap/rating-bar/rating-bar.component';
// import { ViewEncapsulationComponent } from './bai_tap/view-encapsulation/view-encapsulation.component';
// import { ViewDefaultComponent } from './bai_tap/view-default/view-default.component';
// import { ViewShadowDomComponent } from './bai_tap/view-shadow-dom/view-shadow-dom.component';
// import { ViewNoneComponent } from './bai_tap/view-none/view-none.component';
// import { ProgressBarComponent } from './bai_tap/progress-bar/progress-bar.component';
// import { NameCardComponent } from './bai_tap/name-card/name-card.component';
import { PipeDemoComponent } from './bai_tap/pipe-demo/pipe-demo.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerComponent,
    CountdownTimerGetSetComponent,
    CountdownTimerOnchangesComponent,
    CountdownTimerAliasComponent,
    CountdownTimerEventComponent,
    CountdownTimerEventAliasComponent,
    RatingBarComponent,
    // ViewEncapsulationComponent,
    // ViewDefaultComponent,
    // ViewShadowDomComponent,
    // ViewNoneComponent,
    ProgressBarComponent,
    NameCardComponent,
    PipeDemoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
