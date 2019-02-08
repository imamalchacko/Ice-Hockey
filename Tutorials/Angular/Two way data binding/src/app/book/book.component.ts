import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  @Input() title: string;
  @Input() author: string;
  @Input() publisher: string;
  @Output() sendBook:EventEmitter<any>=new EventEmitter();
  selectBook(){
    let selectedBook:any= {stitle:this.title, sauthor:this.author, spublisher:this.publisher};
      this.sendBook.emit(selectedBook);
  }
  constructor() { }

  ngOnInit() {
  }

}
