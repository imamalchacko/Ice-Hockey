import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {
  public BookDetails=[{title:"Book 1",author: "author 1", publisher: "publisher 1"},
  {title:"Book 2",author: "author 2", publisher: "publisher 2"},
  {title:"Book 3",author: "author 3", publisher: "publisher 3"}];

  selbook:any;
  addBook(data:any){
    this.selbook=data;
  }


  constructor() { }

  ngOnInit() {
  }

}
