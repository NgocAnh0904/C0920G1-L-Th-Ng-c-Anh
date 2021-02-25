import { Component, OnInit } from '@angular/core';
import {DictionaryService, IWord} from '../../dictionary.service';


@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.scss']
})
export class DictionaryComponent implements OnInit {
  word: IWord | undefined;
  constructor(private dictionaryService: DictionaryService) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
  }

  // tslint:disable-next-line:typedef
  search(word: string) {
    const meaning = this.dictionaryService.search(word);
    this.word = {
      key: word,
      meaning
    };
  }

}
