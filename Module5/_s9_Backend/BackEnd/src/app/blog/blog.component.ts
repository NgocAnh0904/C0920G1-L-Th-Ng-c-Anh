import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PostService} from "../post.service";

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {
  // @ts-ignore
  postList: IPost[] = [];
  // @ts-ignore
  postForm: FormGroup;

  constructor(
    private postService: PostService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.postForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]],
    });
    this.postService
      .getPosts()
      .subscribe((next: any[]) => (this.postList = next), (error: any) => (this.postList = []));
  }

  onSubmit() {
    // @ts-ignore
    if (this.postForm.valid) {
      // @ts-ignore
      const {value} = this.postForm;
      // @ts-ignore
      this.postService.createPost(value)
        .subscribe((next: any) => {
          this.postList.unshift(next);
          // @ts-ignore
          this.postForm.reset({
            title: '',
            body: ''
          });
        }, (error: any) => console.log(error));
    }
  }

  deletePost(i: string | number){
    // @ts-ignore
    const post = this.postList[i];
    // @ts-ignore
    this.postService.deletePost(post.id).subscribe(() => {
      this.postList = this.postList.filter(t => t.id !== post.id);
    });
  }

}
