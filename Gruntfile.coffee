module.exports = (grunt) ->
  grunt.initConfig
    copy:
      main:
        files: [
          cwd: 'web'
          src: ['**']
          dest: 'dist'
          expand: true
        ]

    clean:
      main: ['dist'],
      dist: ['dist/scripts', 'dist/less', 'dist/libs', 'dist/test']

    requirejs:
      options:
        baseUrl: 'dist/scripts'
        name: '../libs/almond/almond'
        mainConfigFile: 'web/scripts/config.js'
        out: 'dist/dist/main.min.js'
        include: ['main']
      prod:
        options:
          out: 'dist/dist/main.min.js'
          optimize: 'uglify2'
      dev:
        options:
          out: 'dist/dist/main.js'
          optimize: 'none'

    less:
      options:
        paths: ['dist/less']
      prod:
        files:
          'dist/dist/styles.min.css': 'dist/less/styles.less'
        options:
          compress: true
      dev:
        files:
          'dist/dist/styles.css': 'dist/less/styles.less'
        options:
          compress: false

    htmlmin:
      options:
        removeComments: true
        collapseWhitespace: true

      prod:
        files:
          'dist/index.html': 'dist/index.html'

    processhtml:
      main:
        files: {'dist/index.html': ['dist/index.html']}

  grunt.loadNpmTasks 'grunt-contrib-clean'
  grunt.loadNpmTasks 'grunt-contrib-copy'
  grunt.loadNpmTasks 'grunt-contrib-requirejs'
  grunt.loadNpmTasks 'grunt-contrib-less'
  grunt.loadNpmTasks 'grunt-contrib-htmlmin'

  grunt.loadNpmTasks 'grunt-processhtml'

  grunt.registerTask 'production', ['clean:main', 'copy', 'requirejs:prod', 'less:prod', 'processhtml', 'htmlmin:prod', 'clean:dist']
  grunt.registerTask 'dev', ['clean:main', 'copy', 'requirejs:dev', 'less:dev']