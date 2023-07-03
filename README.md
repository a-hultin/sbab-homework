# sbab-homework
Homework assigment for SBAB interview.
A spring-boot application

## How to run
<p>Ensure TRAFIKLAB_APIKEY is set in the environment:</p>
<code>%> export TRAFIKLAB_APIKEY=<api key></code>
<p></p>
<p>Start app</p>
<code>%> mvn spring-boot:run</code>

## Example output
<p>Output from an example run can be found in file: <code>run-output.txt</code></p>

## Comments
<p><ul>
  <li>In hindsight, a more suitable architecture would've been to load data sets into SQL database (H2) and issue queries.</li>
  <li>TraficLab api gives 153 stops on line 631. sl.se gives approx 130 stops for line 631. Reason for this discrepancy needs to be investigated.</li>
</ul></p>
