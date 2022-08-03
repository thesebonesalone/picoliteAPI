angular.module('PicoLiteMVC.services', [])
.factory('articleApiService', function($http) {
    var articleApi = {};

    articleApi.getArticles = function() {


        let test = $http.get('http://localhost:8080/picolitemvc/articles');
        return test;
    }

    articleApi.getArticle = function(id) {
        return $http.get('http://localhost:8080/picolitemvc/articles/' + id);
    }
    articleApi.saveArticle = function(data,scope, location) {
        var request = {
            method: "POST",
            url: "http://localhost:8080/picolitemvc/articles",
            headers: {
                'Content-Type': 'application/json'
            },
            data: angular.toJson(data)
        }
        console.log(request)
        $http(request).then((resp) => {
            console.log(resp.data.id)
            scope.id = resp.data.id
            location.path('/article/' + resp.data.id)
        }, () => {
            scope.id = 0;
        })
    }

    articleApi.createComment = function(data, callback)
    {
        var request = {
            method: "POST",
            url: "http://localhost:8080/picolitemvc/comments/",
            headers: {
                'Content-Type': 'application/json'
            },
            data: angular.toJson(data)

        }
        $http(request).then((resp) => {
            console.log(resp)
            callback;
        }, (err) => {
            console.log("in error")
            console.log(err)
        })
    }

    articleApi.loadComments = function(id) {
        return data = $http.get("http://localhost:8080/picolitemvc/comments/article/" + id);
    }

    articleApi.deleteArticle = function(location, id) {
        var request = {
            method: "DELETE",
            url: "http://localhost:8080/picolitemvc/articles/" + id
        }
        $http(request).then((resp) => {
            location.path('/home');

        }, ()=> {

        })

    }
    return articleApi;
})