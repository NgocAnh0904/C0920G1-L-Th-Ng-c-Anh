"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.YoutubePlayerComponent = void 0;
var core_1 = require("@angular/core");
var YoutubePlayerComponent = /** @class */ (function () {
    function YoutubePlayerComponent(youtubeService, activatedRouter, domSanitizer) {
        this.youtubeService = youtubeService;
        this.activatedRouter = activatedRouter;
        this.domSanitizer = domSanitizer;
    }
    YoutubePlayerComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.activatedRouter.paramMap.subscribe(function (paramMap) {
            var id = paramMap.get('id');
            // @ts-ignore
            _this.song = _this.youtubeService.find(id);
        });
    };
    // tslint:disable-next-line:typedef
    YoutubePlayerComponent.prototype.getSrc = function () {
        var url = 'https://www.youtube.com/embed/' + this.song.id;
        return this.domSanitizer.bypassSecurityTrustResourceUrl(url);
    };
    // tslint:disable-next-line:typedef
    YoutubePlayerComponent.prototype.ngOnDestroy = function () {
        // @ts-ignore
        this.sub.unsubscribe();
    };
    YoutubePlayerComponent = __decorate([
        core_1.Component({
            selector: 'app-youtube-player',
            templateUrl: './youtube-player.component.html',
            styleUrls: ['./youtube-player.component.scss']
        })
    ], YoutubePlayerComponent);
    return YoutubePlayerComponent;
}());
exports.YoutubePlayerComponent = YoutubePlayerComponent;
