# -*- encoding: utf-8 -*-
from google.appengine.ext import webapp
from google.appengine.ext.webapp.util import run_wsgi_app
import random
class MainHandler(webapp.RequestHandler):
    formdata = '''<form method="post" action="/">
Introduce un número entre 1 y 100: <input type="text" name="resp"/><br />
<input type="submit"/>
</form>'''
    def get(self):
        self.response.headers['Content-Type'] = 'text/html'
        self.response.out.write(self.formdata)
    def post(self):
        resp = self.request.get('resp')
        try:
            resp = int(resp)
        except:
            resp = -1
        answer = random.randint(1, 100)
        if resp < answer:
            msg = 'Tu número es demasiado bajo'
        if resp is answer:
            msg = 'Has acertado campeón, toma un pin!'
        if resp > answer:
            msg = 'Tu número es demasiado alto'
        self.response.out.write('Tu número es : '+str(resp)+'<br />\n')
        self.response.out.write(msg+'\n')
        self.response.out.write(self.formdata)
def main():
    application = webapp.WSGIApplication(
                                         [('/.*', MainHandler)],
                                         debug=True)
    run_wsgi_app(application)
if __name__ is '__main__':
    main()