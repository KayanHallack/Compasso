import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { GithubRouting } from './github.routing';
import { GithubComponent } from './github.component';
import { InputModule } from 'src/app/components/input/input.module';
import { ButtonModule } from 'src/app/components/button/button.module';
import { TableModule } from 'src/app/components/table/table.module';
import { ModalModule } from './../../components/modal/modal.module';

@NgModule({
  declarations: [GithubComponent],
  imports: [
    CommonModule,
    FormsModule,
    GithubRouting,
    InputModule,
    ButtonModule,
    TableModule,
    ModalModule
  ]
})
export class GithubModule { }
