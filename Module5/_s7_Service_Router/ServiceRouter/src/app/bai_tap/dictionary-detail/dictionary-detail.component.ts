import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

import { Subscription } from 'rxjs';
import {DictionaryService, IWord} from '../../dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.scss']
})
export class DictionaryDetailComponent implements OnInit, OnDestroy {

  word: IWord | undefined;
  sub: Subscription | undefined;
  constructor(
    private activatedRoute: ActivatedRoute,
    private dictionaryService: DictionaryService
    ) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    /*
    const {snapshot} = this.activatedRoute;
    const key = snapshot.paramMap.get('key');
    const meaning = this.dictionaryService.search(key);
    this.word = {
      key: key,
      meaning: meaning
    };
    */
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const key = paramMap.get('key')!;
      const meaning = this.dictionaryService.search(key);
      this.word = {
        key: key,
        meaning : meaning
      };
    });
  }
  ngOnDestroy(): void {
    // @ts-ignore
    this.sub.unsubscribe();
  }

}
