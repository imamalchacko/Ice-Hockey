<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Students extends Model
{
    public $fillable=[
        'name',
        'rno',
        'dept',
        'class',
        'age',
    ];
}
