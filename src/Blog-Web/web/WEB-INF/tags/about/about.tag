
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<form action="${pageContext.servletContext.contextPath}/about" method="post">
      <article class="row">
        <section class="two thirds padded bounceInDown animated">
          <h1>Contact Us</h1>
          <p>We love to hear from you and welcome your feedback. Use the form below to send us an email:</p>
          <form>
            <fieldset>
              <legend>Contact Form</legend>
              <div class="row">
                <div class="one fourth padded">
                  <label for="name">Your Name</label>
                </div>
                <div class="three fourths padded ">
                  <input id="name" name="name" type="text" placeholder="Your Name">
                </div>
              </div>
              <div class="row">
                <div class="one fourth padded ">
                  <label for="email">Your Email</label>
                </div>
                <div class="three fourths padded">
                  <input id="email" name="email" type="text" placeholder="you@example.com">
                </div>
              </div>
              <div class="row">
                <div class="one whole pad-left pad-right pad-top">
                  <label for="message">Your Message</label>
                </div>
              </div>
              <div class="row">
                <div class="one whole pad-left pad-right pad-bottom">
                  <textarea id="message" name="message" placeholder="Write us a message here..."></textarea>
                </div>
              </div>
              <div class="row">
                <div class="one whole padded align-right">
                  <button type="submit" class="asphalt">Send Message</button>
                </div>
              </div>
            </fieldset>
          </form>
        </section>
        <aside class="one  third padded bounceInRight animated">
          <h3>Our Location</h3>
          <h5>
            <address>Russia, Saint-Petersburg, prospekt Geroyev, 18</address>
          </h5>
                    <iframe width="100%" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://yandex.ru/map-widget/v1/?um=constructor%3A8e51db7c683bcb7cb66dc87c0c3403de9727e1869114681918a97f5d6cef3f7c&amp;source=constructor" width="500" height="400" frameborder="0"></iframe>
        </aside>
      </article>
    </div>
</form>