import AccessibilityImageAlt from './buttons/accessibility/accessibility_image_alt.jsx';

import BackgroundColor from './buttons/color/background_color.jsx';
import Color from './buttons/color/color.jsx';

import EmbedVideo from './buttons/embed/embed_video.jsx';
import EmbedVideoEdit from './buttons/embed/embed_video_edit.jsx';

import AlignImageCenter from './buttons/align_image/align_image_center.jsx';
import AlignImageLeft from './buttons/align_image/align_image_left.jsx';
import AlignImageRight from './buttons/align_image/align_image_right.jsx';

import ItemSelectorAudio from './buttons/item_selector/item_selector_audio.jsx';
import ItemSelectorImage from './buttons/item_selector/item_selector_image.jsx';
import ItemSelectorVideo from './buttons/item_selector/item_selector_video.jsx';

import LinkBrowse from './buttons/link_browse/link_browse.jsx';
import LinkEditBrowse from './buttons/link_browse/link_edit_browse.jsx';

import Spacing from './buttons/spacing/spacing.jsx';

import './plugins/embed_url/plugin.js';

import embedUrlSelectionTest from './selections/embed_url_selection_test.js';
import headingTextSelectionTest from './selections/heading_selection_test.js';

AlloyEditor.Buttons[AccessibilityImageAlt.key] = AlloyEditor.AccessibilityImageAlt = AccessibilityImageAlt;

AlloyEditor.Buttons[BackgroundColor.key] = AlloyEditor.BackgroundColor = BackgroundColor;
AlloyEditor.Buttons[Color.key] = AlloyEditor.Color = Color;

AlloyEditor.Buttons[AlignImageCenter.key] = AlloyEditor.AlignImageCenter = AlignImageCenter;
AlloyEditor.Buttons[AlignImageLeft.key] = AlloyEditor.AlignImageLeft = AlignImageLeft;
AlloyEditor.Buttons[AlignImageRight.key] = AlloyEditor.AlignImageRight = AlignImageRight;

AlloyEditor.Buttons[EmbedVideo.key] = AlloyEditor.EmbedVideo = EmbedVideo;
AlloyEditor.Buttons[EmbedVideoEdit.key] = AlloyEditor.EmbedVideoEdit = EmbedVideoEdit;

AlloyEditor.Buttons[ItemSelectorAudio.key] = AlloyEditor.ItemSelectorAudio = ItemSelectorAudio;
AlloyEditor.Buttons[ItemSelectorImage.key] = AlloyEditor.ItemSelectorImage = ItemSelectorImage;
AlloyEditor.Buttons[ItemSelectorVideo.key] = AlloyEditor.ItemSelectorVideo = ItemSelectorVideo;

AlloyEditor.Buttons[LinkBrowse.key] = AlloyEditor.LinkBrowse = LinkBrowse;
AlloyEditor.Buttons[LinkEditBrowse.key] = AlloyEditor.LinkEditBrowse = LinkEditBrowse;

AlloyEditor.Buttons[Spacing.key] = AlloyEditor.Spacing = Spacing;

AlloyEditor.SelectionTest = AlloyEditor.SelectionTest || {};

AlloyEditor.SelectionTest.embedurl = embedUrlSelectionTest;
AlloyEditor.SelectionTest.headingtext = headingTextSelectionTest;