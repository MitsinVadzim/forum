import {Component, OnInit, ViewChild} from '@angular/core';
import {Post} from "../model/post.model";
import {MatPaginator, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  private loading  =  true;
  private posts: Post[] = [
    {id: '1', title: 'Test title', content: 'dsafsaf;jhasjhfouewnfsdjangpdsufohadiusbfdsaibfadspiuvnz;cuvnouzfdhpaoerhweqofgndpjksfaml;sadknvlakdnf;ldajf;jrhajekbfjasdbvjabfdjshafsdhafjsadhf;sadkjf content', imageUrl: 'Test image url'}
  ];
  private dataSource  =  new  MatTableDataSource<Post>(this.posts);
  private displayedColumns  = ['id', 'title', 'content', 'imageUrl', 'operations'];
  @ViewChild(MatPaginator, {static: true}) paginator:  MatPaginator;

  constructor() { }

  ngOnInit() {
    setTimeout(() => {

      this.loading  =  false;

    }, 2000);
  }

  ngAfterViewInit() {
    this.dataSource.paginator  =  this.paginator;
  }

}
