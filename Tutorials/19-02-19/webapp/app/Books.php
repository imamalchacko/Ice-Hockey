<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Books extends Model
{
    public $fillable=[
        'title',
        'body',
    ];
}
