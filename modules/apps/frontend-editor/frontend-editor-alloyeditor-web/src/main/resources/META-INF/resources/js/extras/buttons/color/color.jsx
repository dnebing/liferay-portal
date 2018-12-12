const React = AlloyEditor.React;

/**
 * The Color class provides functionality for changing text color in a document.
 *
 * @uses ButtonStateClasses
 * @uses ButtonCfgProps
 *
 * @class Color
 */
const Color = React.createClass({
	mixins: [ AlloyEditor.ButtonStateClasses, AlloyEditor.ButtonCfgProps],

	// Allows validating props being passed to the component.
	propTypes: {
		/**
		 * The editor instance where the component is being used.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Object} editor
		 */
		editor: React.PropTypes.object.isRequired,

		/**
		 * Indicates whether the styles list is expanded or not.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Boolean} expanded
		 */
		expanded: React.PropTypes.bool,

		/**
		 * The label that should be used for accessibility purposes.
		 *
		 * @instance
		 * @memberof Color
		 * @property {String} label
		 */
		label: React.PropTypes.string,

		/**
		 * Indicates whether the remove styles item should appear in the styles list.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Boolean} showRemoveStylesItem
		 */
		showRemoveStylesItem: React.PropTypes.bool,

		/**
		 * List of the styles the button is able to handle.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Array} styles
		 */
		styles: React.PropTypes.arrayOf(React.PropTypes.object),

		/**
		 * The tabIndex of the button in its toolbar current state. A value other than -1
		 * means that the button has focus and is the active element.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Number} tabIndex
		 */
		tabIndex: React.PropTypes.number,

		/**
		 * Callback provided by the button host to notify when the styles list has been expanded.
		 *
		 * @instance
		 * @memberof Color
		 * @property {Function} toggleDropdown
		 */
		toggleDropdown: React.PropTypes.func
	},

	// Lifecycle. Provides static properties to the widget.
	statics: {
		key: 'color'
	},

	/**
	 * Lifecycle. Renders the UI of the button.
	 *
	 * @method render
	 * @return {Object} The content which should be rendered.
	 */
	render: function() {
		var activeColor = AlloyEditor.Strings.normal;

		var activeColorClass = 'text-body';

		var colors = this._getColors();

		colors.forEach(function (item) {
			if (this._checkActive(item.style)) {
				activeColor = item.name;

				activeColorClass = item.style.attributes.class;
			}
		}.bind(this));

		var buttonIconPath =
			themeDisplay.getPathThemeImages() + '/lexicon/icons.svg#text-editor';

		var buttonStylesProps = {
			activeStyle: activeColor,
			editor: this.props.editor,
			onDismiss: this.props.toggleDropdown,
			showRemoveStylesItem: false,
			styles: colors
		};

		return (
			<div className="ae-container ae-has-dropdown">
				<button
					aria-expanded={this.props.expanded}
					className="ae-toolbar-element"
					onClick={this.props.toggleDropdown}
					role="combobox"
					tabIndex={this.props.tabIndex}
				>
					<span className={activeColorClass}>
						<svg className="lexicon-icon">
							<use href={buttonIconPath}/>
						</svg>
					</span>
				</button>
				{this.props.expanded &&
				 <AlloyEditor.ButtonStylesList {...buttonStylesProps} />
				}
			</div>
		);
	},

	_applyStyle: function(className) {
		var editor = this.props.editor.get('nativeEditor');

		var styleConfig = {
			element: 'span',
			attributes: {
				class: className
			}
		};

		var style = new CKEDITOR.style(styleConfig);

		editor.getSelection().lock();

		this._getColors().forEach(
			function(item) {
				if (this._checkActive(item.style)) {
					editor.removeStyle(new CKEDITOR.style(item.style));
				}
			}.bind(this)
		);

		editor.applyStyle(style);

		editor.getSelection().unlock();

		editor.fire('actionPerformed', this);
	},

	/**
	 * Checks if the given color definition is applied to the current selection in the editor.
	 *
	 * @instance
	 * @memberof ButtonColor
	 * @method _checkActive
	 * @param {Object} styleConfig Color definition as per http://docs.ckeditor.com/#!/api/CKEDITOR.style.
	 * @protected
	 * @return {Boolean} Returns true if the color is applied to the selection, false otherwise.
	 */
	_checkActive: function(styleConfig) {
		var nativeEditor = this.props.editor.get('nativeEditor');

		// Styles with wildcard element (*) won't be considered active by CKEditor. Defaulting
		// to a 'span' element works for most of those cases with no defined element.
		styleConfig = CKEDITOR.tools.merge({ element: 'span' }, styleConfig);

		var style = new CKEDITOR.style(styleConfig);

		return style.checkActive(nativeEditor.elementPath(), nativeEditor);
	},

	/**
	 * Returns an array of colors. Each color consists from two properties:
	 * - name - the style name, for example "default"
	 * - style - an object with one property, called `element` which value
	 * represents the style which have to be applied to the element.
	 *
	 * @instance
	 * @memberof ButtonColor
	 * @method _getColor
	 * @protected
	 * @return {Array<object>} An array of objects containing the colors.
	 */
	_getColors: function() {
		return this.props.styles || [{
			name: AlloyEditor.Strings.normal,
			style: {
				element: 'span',
				attributes: {
					class: 'text-body'
				}
			},
			styleFn: this._applyStyle.bind(this, '')
		}, {
			name: Liferay.Language.get('primary'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-primary'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-primary')
		}, {
			name: Liferay.Language.get('disabled'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-secondary'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-secondary')
		}, {
			name: Liferay.Language.get('success'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-success'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-success')
		}, {
			name: Liferay.Language.get('danger'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-danger'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-danger')
		}, {
			name: Liferay.Language.get('warning'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-warning'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-warning')
		}, {
			name: Liferay.Language.get('info'),
			style: {
				element: 'span',
				attributes: {
					class: 'text-info'
				}
			},
			styleFn: this._applyStyle.bind(this, 'text-info')
		}];
	}

});

export default Color;
export {Color};