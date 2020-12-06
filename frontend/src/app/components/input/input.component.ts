import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.scss'],
})
export class InputComponent implements OnInit {

  @Input()
  public id = 'id';

  @Input()
  public type = 'text';

  @Input()
  public label!: string;

  @Input()
  public placeholder!: string;

  @Input()
  public readonly = false;

  @Input()
  public value: any;

  constructor() {}

  ngOnInit(): void {}
}
