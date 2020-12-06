import { Component, Input, OnInit, TemplateRef } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  @Input() 
  public modalRef!: string;

  @Input() 
  public size!: string;

  @Input() 
  public title!: string;

  @Input() 
  public body!: TemplateRef<any>;

  constructor() { }

  ngOnInit(): void {

  }

}
