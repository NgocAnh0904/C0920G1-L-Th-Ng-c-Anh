import {Component, OnDestroy, OnInit} from '@angular/core';
import {YoutubeService} from '../youtube.service';
import {Subscription} from 'rxjs';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-youtube-player',
  templateUrl: './youtube-player.component.html',
  styleUrls: ['./youtube-player.component.scss']
})
export class YoutubePlayerComponent implements OnInit, OnDestroy {
  song: any;
  sub: Subscription | undefined;
  constructor(
    private youtubeService: YoutubeService,
    private activatedRouter: ActivatedRoute,
    private domSanitizer: DomSanitizer
  ){}

  ngOnInit(): void {this.sub = this.activatedRouter.paramMap.subscribe((paramMap: ParamMap) => {
    const id = paramMap.get('id');
    // @ts-ignore
    this.song = this.youtubeService.find(id);
  });
  }

  // tslint:disable-next-line:typedef
  getSrc() {
    const url = 'https://www.youtube.com/embed/' + this.song.id;
    return this.domSanitizer.bypassSecurityTrustResourceUrl(url);
  }

  // tslint:disable-next-line:typedef
  ngOnDestroy() {
    // @ts-ignore
    this.sub.unsubscribe();
}
}