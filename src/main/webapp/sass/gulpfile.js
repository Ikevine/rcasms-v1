const{ src , dest , watch , series} = require('gulp')
const sass = require('gulp-sass')(require('sass'))

function buildStyle(){
    return src("**/*.scss")
        .pipe(sass())
        .pipe(dest('css'))
}


function watcher(){
    watch(['**/*.scss'] , buildStyle)
}


exports.default = series(buildStyle , watcher)