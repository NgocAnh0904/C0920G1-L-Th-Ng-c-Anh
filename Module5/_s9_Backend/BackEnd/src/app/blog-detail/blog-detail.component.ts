import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../post.service";
import {IPost} from "../post";

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.scss']
})
export class BlogDetailComponent implements OnInit {
  post: IPost | undefined;
  constructor(
    private route: ActivatedRoute,
    private postService: PostService
  ) {}

  ngOnInit() {
    // @ts-ignore
    const id = +this.route.snapshot.paramMap.get('id');
    // @ts-ignore
    this.postService.getPostById(id).subscribe(
        (next: any) => (this.post = next),
        (error: any) => {
        console.log(error);
        // @ts-ignore
          this.post = null;
      }
    );
  }

}
