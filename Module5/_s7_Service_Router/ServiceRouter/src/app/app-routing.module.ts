import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import {HomeComponent} from './bai_tap/home/home.component';
import {DictionaryPageComponent} from './bai_tap/dictionary-page/dictionary-page.component';
import {DictionaryDetailComponent} from './bai_tap/dictionary-detail/dictionary-detail.component';
import {TimelinesComponent} from './thuc_hanh/timelines/timelines.component';
import {YoutubePlaylistComponent} from './thuc_hanh/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './thuc_hanh/youtube-player/youtube-player.component';
import {LoginStep1Component} from './bai_tap/login-step1/login-step1.component';
import {LoginStep2Component} from './bai_tap/login-step2/login-step2.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'dictionary',
    component: DictionaryPageComponent,
    children: [
      {
        path: ':key',
        component: DictionaryDetailComponent,
        canActivate: [AuthGuard]
      }
    ]
  },
  {
    path: 'blog',
    loadChildren: './blog/blog.module#BlogModule'
  }, {
    path: 'timelines',
    component: TimelinesComponent
  },
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  },
  {
    path: 'login-step-1',
    component: LoginStep1Component
  },
  {
    path: 'login-step-2',
    component: LoginStep2Component
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
