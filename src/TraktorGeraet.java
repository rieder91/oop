/**
 * Interface that all devices that can be attached to a Traktor implement
 * @author Thomas
 *
 */
@Creator(name = "Thomas", lastUpdate = "08.12.2012")
public interface TraktorGeraet {
	/**
	 * @return returns the specific detail that each device has (i.e. Fassungsvolumen)
	 */
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	public Object getDetail();
}
