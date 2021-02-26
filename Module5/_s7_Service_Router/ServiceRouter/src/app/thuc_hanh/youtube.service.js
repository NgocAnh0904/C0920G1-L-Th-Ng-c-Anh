"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.YoutubeService = void 0;
var core_1 = require("@angular/core");
var YoutubeService = /** @class */ (function () {
    function YoutubeService() {
        this.playlist = [
            { id: 'CX11yw6YL1w', song: 'Céline Dion - Ashes (from the Deadpool 2 Motion Picture Soundtrack)' },
            { id: 'HBYirj2c_jw', song: 'Deadpool 2 - Take on Me' },
            { id: 'N6O2ncUKvlg', song: 'Nelly - Just A Dream' },
            { id: 'uelHwf8o7_U', song: 'Eminem - Love The Way You Lie ft. Rihanna' },
            { id: 'WpYeekQkAdc', song: 'The Black Eyed Peas - Where Is The Love?' }
        ];
    }
    YoutubeService.prototype.find = function (id) {
        return this.playlist.find(function (item) { return item.id === id; });
    };
    YoutubeService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], YoutubeService);
    return YoutubeService;
}());
exports.YoutubeService = YoutubeService;
