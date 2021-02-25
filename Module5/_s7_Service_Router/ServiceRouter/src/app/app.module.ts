import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { DictionaryService } from './dictionary.service';
import {DictionaryComponent} from './bai_tap/dictionary/dictionary.component';
import {DictionaryPageComponent} from './bai_tap/dictionary-page/dictionary-page.component';
import {HomeComponent} from './bai_tap/home/home.component';
import {DictionaryDetailComponent} from './bai_tap/dictionary-detail/dictionary-detail.component';
import {TimelinesComponent} from './thuc_hanh/timelines/timelines.component';
import {YoutubePlaylistComponent} from './thuc_hanh/youtube-playlist/youtube-playlist.component';
import {LoginStep2Component} from './bai_tap/login-step2/login-step2.component';
import {LoginStep1Component} from './bai_tap/login-step1/login-step1.component';
import {YoutubePlayerComponent} from './thuc_hanh/youtube-player/youtube-player.component';


@NgModule({
  declarations: [
    AppComponent,
    DictionaryComponent,
    DictionaryPageComponent,
    HomeComponent,
    DictionaryDetailComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    LoginStep1Component,
    LoginStep2Component
  ],
  imports: [BrowserModule, ReactiveFormsModule, AppRoutingModule],
  providers: [DictionaryService],
  bootstrap: [AppComponent]
})
export class AppModule {}
